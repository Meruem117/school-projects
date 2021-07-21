/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 *
 * @author Meruem
 */
public class P3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        
        Job job = Job.getInstance(conf);
        job.setJarByClass(P3.class);
        job.setMapperClass(WcMapper.class);
        job.setReducerClass(WcReducer.class);
        
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        FileInputFormat.setInputPaths(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

    public static class WcMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

        private Text word = new Text();
        protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
                throws IOException, InterruptedException {
            String[] ss = value.toString().split("\\s+");
            if (ss != null&& ss.length>=8) {
                String a = ss[7];
                if (a.equals("read")) {
                    word.set(ss[8]);
                context.write(new Text(word), new IntWritable(1));
            }
        }
        }
    }
    public static class WcReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

        Map<String, Integer> map = new HashMap<String, Integer>();

        protected void reduce(Text key, Iterable<IntWritable> iter,
                Reducer<Text, IntWritable, Text, IntWritable>.Context conext) throws IOException, InterruptedException {
            int count = 0;
            for (IntWritable wordCount : iter) {
                count += wordCount.get();
            }
            String name = key.toString();
            map.put(name, count);
        }

        @Override
        protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
                throws IOException, InterruptedException {
            List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

                public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
                    return (int) (arg1.getValue() - arg0.getValue());
                }
            });
            for (int i = 0; i < 3; i++) {
                context.write(new Text(list.get(i).getKey()), new IntWritable(list.get(i).getValue()));
            }
        }
    }

}