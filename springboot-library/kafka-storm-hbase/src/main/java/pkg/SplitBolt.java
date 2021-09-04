package pkg;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;



public class SplitBolt implements IRichBolt {
    private OutputCollector collector;

    public void prepare(Map stormConf, TopologyContext context,
                        OutputCollector collector) {
        this.collector = collector;
    }

    public void execute(Tuple input) {
        String sentence = input.getString(0);

        if(sentence.contains("service.Read")){
            String[] words = sentence.split("\\s+");
            this.collector.emit(new Values(words[words.length - 1]));
        }

        collector.ack(input);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word"));
    }

    public void cleanup() {}

    public Map<String, Object> getComponentConfiguration() {
        return null;
    }

}