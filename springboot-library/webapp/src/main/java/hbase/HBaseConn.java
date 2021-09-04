package hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

public class HBaseConn {

    public static final HBaseConn INSTANCE = new HBaseConn();
    public static Configuration config;
    public static Connection conn;

    /**
     * 获取HBase连接 - 单例
     *
     * @return
     */
    public static Connection getHBaseConnection() {
        return INSTANCE.getConn();
    }

    public static void closeHBaseConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过表名获取HBase表
     *
     * @param tableName
     * @return Table的实例
     * @throws IOException
     */
    public static Table getTable(String tableName) throws IOException {
        return INSTANCE.getConn().getTable(TableName.valueOf(tableName));
    }

    /**
     * 私有构造 初始化时需指定zookeeper所在的主机名和端口号
     */
    private HBaseConn() {
        if (config == null) {
            config = HBaseConfiguration.create();
            config.set("hbase.zookeeper.quorum", "hadoop000:2181");
        }
    }

    /**
     * 获得连接
     *
     * @return 连接的实例
     */
    private Connection getConn() {
        if (conn == null || conn.isClosed()) {
            try {
                conn = ConnectionFactory.createConnection(config);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
