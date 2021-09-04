package pkg;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.hbase.bolt.HBaseBolt;
import org.apache.storm.hbase.bolt.mapper.SimpleHBaseMapper;
import org.apache.storm.kafka.spout.ByTopicRecordTranslator;
import org.apache.storm.kafka.spout.FirstPollOffsetStrategy;
import org.apache.storm.kafka.spout.KafkaSpout;
import org.apache.storm.kafka.spout.KafkaSpoutConfig;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.HashMap;
import java.util.Map;

public class StormKafkaMain {
    private static final String BOOTSTRAP_SERVER = "hadoop000:9092";
    private static final String TOPIC = "my-topic-project";

    public static void main(String[] args) throws Exception {

        TopologyBuilder builder = new TopologyBuilder();
        Config conf = new Config();
        conf.setNumAckers(0);
        conf.setNumWorkers(2);
        conf.setDebug(true);



        // hbase conf
        Map<String, Object> hbConf = new HashMap<>();
        hbConf.put("hbase.rootdir", "hdfs://hadoop000:9000/hbase");
        hbConf.put("hbase.zookeeper.quorum", "hadoop000:2181");

        conf.put("hbase.conf", hbConf);

        SimpleHBaseMapper mapper = new SimpleHBaseMapper()
                .withRowKeyField("word")
//                .withColumnFields(new Fields("word"))
                .withColumnFields(new Fields("count"))
                .withColumnFamily("cf");

        HBaseBolt hBaseBolt = new HBaseBolt("p2", mapper).withConfigKey("hbase.conf");

        ByTopicRecordTranslator<String, String> translator = new ByTopicRecordTranslator<>((r) -> new Values(r.value(), r.topic()), new Fields("value", "topic"));
        translator.forTopic(TOPIC, (r) -> new Values(r.value(), r.topic()), new Fields("value", "topic"));

        KafkaSpoutConfig<String, String> kafkaSpoutConfig = KafkaSpoutConfig
                .builder(BOOTSTRAP_SERVER, TOPIC)
                .setProp(ConsumerConfig.GROUP_ID_CONFIG, "g1")
                .setProp(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
                .setFirstPollOffsetStrategy(FirstPollOffsetStrategy.LATEST)
                .setOffsetCommitPeriodMs(10_000)
                .setRecordTranslator(translator)
                .build();

        builder.setSpout("kafka-spout", new KafkaSpout<>(kafkaSpoutConfig), 2);
        builder.setBolt("split-bolt", new SplitBolt(), 4).shuffleGrouping("kafka-spout");
        builder.setBolt("count-bolt", new CountBolt(), 4).fieldsGrouping("split-bolt", new Fields("word"));
        builder.setBolt("hbase-bolt", hBaseBolt).globalGrouping("count-bolt");


        try {
            LocalCluster localCluster = new LocalCluster();
            localCluster.submitTopology("topo", conf, builder.createTopology());
            // StormSubmitter.submitTopology("topo", conf, builder.createTopology());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
