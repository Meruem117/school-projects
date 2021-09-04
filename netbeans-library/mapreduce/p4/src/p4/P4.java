/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 *
 * @author jenie
 */
public class P4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // TODO code application logic here
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        //check for two parameters for main ()
        if (otherArgs.length != 2) {
            System.err.println("Usage: wordcount <in> <out>");
            System.exit(2); // stop the program
        }
        //create job and set jar file
        Job job = Job.getInstance(conf);
        job.setJobName("CountWord");
        job.setJarByClass(P4.class);

        //set mapper-combiner-reducer classes
        job.setMapperClass(TokenizerMapper.class);
        //job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);

        //set output key -value
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // set path received in main parameter
        FileInputFormat.addInputPath(job, new Path(otherArgs[0])); //read path
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));//write path

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

    public static class TokenizerMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        //output value

        private final static IntWritable one = new IntWritable(1);
        //output key
        private Text word = new Text();

        public void map(LongWritable key, Text value, Reducer.Context context
        ) throws IOException, InterruptedException {
            // it will divide the line into words
//   StringTokenizer itr = new StringTokenizer(value.toString());
//   
//   while (itr.hasMoreTokens()) {
//       //set value to key - it will be first word of your file
//     word.set(itr.nextToken());
//     // set output key and value
//     context.write(word, one);
//   }
            String s = value.toString();
            String[] ss = s.split("\\s+");
            if (ss != null&& ss.length>3) {
                String time = ss[1].substring(0,2);
                
                    word.set(time);
                    context.write(word, one);
                
            }

        }
    }

    public static class IntSumReducer
            extends Reducer<Text, IntWritable, Text, IntWritable> {
        //output value

        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<IntWritable> values,
                Reducer.Context context
        ) throws IOException, InterruptedException {
            //values are many so iterable
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }

            //set output value
            result.set(sum);
            //set output key & value
            context.write(key, result);
        }
    }

}
