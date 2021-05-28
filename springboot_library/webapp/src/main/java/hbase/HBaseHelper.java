package hbase;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HBaseHelper {

    /**
     * 创建HBase 表
     *
     * @param tableName 表名
     * @param cfs 列簇名数组
     * @return 是否创建表成功
     */
    public static boolean createTable(String tableName, String[] cfs) {
        try (HBaseAdmin admin = (HBaseAdmin) HBaseConn.getHBaseConnection().getAdmin()) {
            if (admin.tableExists(tableName)) {
                return false;
            }
            HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
            Arrays.stream(cfs).forEach(cf -> {
                HColumnDescriptor columnDescriptor = new HColumnDescriptor(cf);
                columnDescriptor.setMaxVersions(1);
                tableDescriptor.addFamily(columnDescriptor);
            });
            admin.createTable(tableDescriptor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 删除 HBase表
     *
     * @param tableName 表名
     * @return 是否删除表成功 Exceptions: There could be couple types of IOException
     * TableNotFoundException means the table doesn't exist.
     * TableNotEnabledException means the table isn't in enabled state.
     */
    public static boolean deleteTable(String tableName) {
        try (HBaseAdmin admin = (HBaseAdmin) HBaseConn.getHBaseConnection().getAdmin()) {
            admin.disableTable(tableName);
            admin.deleteTable(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 向HBase表中添加一个单元格数据
     *
     * @param tableName 表名
     * @param rowKey 行键
     * @param cfName 列簇名
     * @param qualifier 列标识
     * @param data 要添加的数据
     * @return 是否成功添加数据
     */
    public static boolean putRow(String tableName, String rowKey, String cfName, String qualifier, String data) {
        try (Table table = HBaseConn.getTable(tableName)) {
            Put putRow = new Put(Bytes.toBytes(rowKey));
            putRow.addColumn(Bytes.toBytes(cfName), Bytes.toBytes(qualifier), Bytes.toBytes(data));
            table.put(putRow);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 向HBase表中添加多个单元格的数据
     *
     * @param tableName 表名
     * @return 是否成功添加数据
     */
    public static boolean putRows(String tableName, List<Put> putRows) {
        try (Table table = HBaseConn.getTable(tableName)) {
            table.put(putRows);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 从HBase表中根据RowKey查询一条数据
     *
     * @param tableName 表名
     * @param rowKey 行键
     * @return 单行数据的结果 可能为 null
     */
    public static Result getRow(String tableName, String rowKey) {
        try (Table table = HBaseConn.getTable(tableName)) {
            Get get = new Get(Bytes.toBytes(rowKey));
            return table.get(get);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从HBase表中根据RowKey查询一条数据 - 使用过滤器
     *
     * @param tableName 表名
     * @param rowKey 行键
     * @return 单行数据的结果 可能为 null
     */
    public static Result getRow(String tableName, String rowKey, FilterList filterList) {
        try (Table table = HBaseConn.getTable(tableName)) {
            Get get = new Get(Bytes.toBytes(rowKey));
            get.setFilter(filterList);
            return table.get(get);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从HBase表中根据表名获取表扫描器
     *
     * @param tableName 表名
     * @return 表扫描器 可能为 null
     */
    public static ResultScanner getScanner(String tableName) {
        try (Table table = HBaseConn.getTable(tableName)) {
            Scan scan = new Scan();
            // 设置缓存的条数
            scan.setCaching(1000);
            return table.getScanner(scan);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从HBase表中根据表名获取表扫描器 - 根据起始和终止RowKey
     *
     * @param tableName 表名
     * @param startRowKey 起始RowKey 包含
     * @param stopRowKey 终止RowKey 不包含
     * @return 表扫描器 可能为 null
     */
    public static ResultScanner getScanner(String tableName, String startRowKey, String stopRowKey) {
        try (Table table = HBaseConn.getTable(tableName)) {
            Scan scan = new Scan();
            scan.setStartRow(Bytes.toBytes(startRowKey));
            scan.setStopRow(Bytes.toBytes(stopRowKey));
            // 设置缓存的条数
            scan.setCaching(1000);
            return table.getScanner(scan);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从HBase表中根据表名获取表扫描器 - 根据起始和终止RowKey, 并添加过滤器
     *
     * @param tableName 表名
     * @param startRowKey 起始RowKey 包含
     * @param stopRowKey 终止RowKey 不包含
     * @param filterList 过滤器列表
     * @return 表扫描器 可能为 null
     */
    public static ResultScanner getScanner(String tableName, String startRowKey, String stopRowKey, FilterList filterList) {
        try (Table table = HBaseConn.getTable(tableName)) {
            Scan scan = new Scan();
            scan.setStartRow(Bytes.toBytes(startRowKey));
            scan.setStopRow(Bytes.toBytes(stopRowKey));
            scan.setFilter(filterList);
            // 设置缓存的条数
            scan.setCaching(1000);
            return table.getScanner(scan);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除一行数据
     *
     * @param tableName 表名
     * @param rowKey 行键
     * @return 是否删除成功
     */
    public static boolean deleteRow(String tableName, String rowKey) {
        try (Table table = HBaseConn.getTable(tableName)) {
            Delete deleteRow = new Delete(Bytes.toBytes(rowKey));
            table.delete(deleteRow);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 从给定HBase表删除一个列簇
     *
     * @param tableName 表名
     * @param cfName 列簇
     * @return 是否删除成功
     */
    public static boolean deleteColumnFamily(String tableName, String cfName) {
        try (HBaseAdmin admin = (HBaseAdmin) HBaseConn.getHBaseConnection().getAdmin()) {
            admin.deleteColumn(tableName, cfName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 从给定HBase表的某行数据的列簇中删除一个列标识
     *
     * @param tableName 表名
     * @param rowKey 行键
     * @param cfName 列簇
     * @param qualifier 列标识
     * @return 是否删除成功
     */
    public static boolean deleteColumnFamily(String tableName, String rowKey, String cfName, String qualifier) {
        try (Table table = HBaseConn.getTable(tableName)) {
            Delete deleteRow = new Delete(Bytes.toBytes(rowKey));
            deleteRow.addColumn(Bytes.toBytes(cfName), Bytes.toBytes(qualifier));
            table.delete(deleteRow);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
