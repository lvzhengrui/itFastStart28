package org.lvzr.fast.bigdata.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;  
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;  
import org.apache.hadoop.hbase.HColumnDescriptor;  
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;  
import org.apache.hadoop.hbase.client.Connection;  
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;  
import org.apache.hadoop.io.LongWritable;  
import org.apache.hadoop.io.NullWritable;  
import org.apache.hadoop.io.Text;  
import org.apache.hadoop.mapreduce.Job;  
import org.apache.hadoop.mapreduce.Mapper;  
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;  
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;  

public class HBaseFilter {  
      
    private static final String TABLE_NAME = "t1";  
    private static HBaseAdmin hBaseAdmin;
    private static final String rowKey = "r1";
    private static Configuration conf;
    
    static {
        conf = HBaseConfiguration.create();
        conf.addResource("hbase-site.xml");
        
        try {
            hBaseAdmin = new HBaseAdmin(conf);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static void createTable(String tableName, String[] columns) throws Exception {
        dropTable(tableName);
        HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
        for (String columnName : columns) {
            HColumnDescriptor column = new HColumnDescriptor(columnName);
            hTableDescriptor.addFamily(column);
        }
        hBaseAdmin.createTable(hTableDescriptor);
        System.out.println("create table successed");
    }


    public static void dropTable(String tableName) throws Exception {
        if (hBaseAdmin.tableExists(tableName)) {
            hBaseAdmin.disableTable(tableName);
            hBaseAdmin.deleteTable(tableName);
        }
        System.out.println("drop table successed");
    }


    public static HTable getHTable(String tableName) throws Exception {
        return new HTable(conf, tableName);
    }


    public static void insert(String tableName, Map<String, String> map) throws Exception {
        HTable hTable = getHTable(tableName);
        byte[] row1 = Bytes.toBytes(rowKey);
        Put p1 = new Put(row1);
        for (String columnName : map.keySet()) {
            byte[] value = Bytes.toBytes(map.get(columnName));
            String[] str = columnName.split(":");
            byte[] family = Bytes.toBytes(str[0]);
            byte[] qualifier = null;
            if (str.length > 1) {
                qualifier = Bytes.toBytes(str[1]);
            }
            p1.add(family, qualifier, value);
        }
        hTable.put(p1);
        Get g1 = new Get(row1);
        Result result = hTable.get(g1);
        System.out.println("Get: " + result);
        System.out.println("insert successed");
    }


    public static void delete(String tableName, String rowKey) throws Exception {
        HTable hTable = getHTable(tableName);
        List<Delete> list = new ArrayList<Delete>();
        Delete d1 = new Delete(Bytes.toBytes(rowKey));
        list.add(d1);
        hTable.delete(list);
        Get g1 = new Get(Bytes.toBytes(rowKey));
        Result result = hTable.get(g1);
        System.out.println("Get: " + result);
        System.out.println("delete successed");
    }


    public static void selectOne(String tableName, String rowKey) throws Exception {
        HTable hTable = getHTable(tableName);
        Get g1 = new Get(Bytes.toBytes(rowKey));
        Result result = hTable.get(g1);
        foreach(result);
        System.out.println("selectOne end");
    }


    private static void foreach(Result result) throws Exception {
        for (KeyValue keyValue : result.raw()) {
            StringBuilder sb = new StringBuilder();
            sb.append(Bytes.toString(keyValue.getRow())).append("\t");
            sb.append(Bytes.toString(keyValue.getFamily())).append("\t");
            sb.append(Bytes.toString(keyValue.getQualifier())).append("\t");
            sb.append(keyValue.getTimestamp()).append("\t");
            sb.append(Bytes.toString(keyValue.getValue())).append("\t");
            System.out.println(sb.toString());
        }
    }


    public static void selectAll(String tableName) throws Exception {
        HTable hTable = getHTable(tableName);
        Scan scan = new Scan();
        ResultScanner resultScanner = null;
        try {
            resultScanner = hTable.getScanner(scan);
            for (Result result : resultScanner) {
                foreach(result);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (resultScanner != null) {
                resultScanner.close();
            }
        }
        System.out.println("selectAll end");
    }
    

    public static void main(String[] args) throws Exception {  

    	String tableName = "tableTest";
        String[] columns = new String[] { "column_A", "column_B" };
        createTable(tableName, columns);
        Map<String, String> map = new HashMap<String, String>();
        map.put("column_A", "AAA");
        map.put("column_B:1", "b1");
        map.put("column_B:2", "b2");
        insert(tableName, map);
        selectOne(tableName, rowKey);
        selectAll(tableName);
        delete(tableName, rowKey);
        dropTable(tableName);
        
        createTable(tableName, columns);
        insert(tableName, map);
        
        // 获取表  
        Connection conn = ConnectionFactory.createConnection(conf);  
        HTable table = (HTable) conn.getTable(TableName.valueOf(TABLE_NAME));  
        // 创建一个扫描对象  
        Scan scan = new Scan();  
        // 创建一个RowFilter过滤器  
        //Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes("abc")));  
        // 将过滤器加入扫描对象  
        //scan.setFilter(filter);  
        // 输出结果  
        ResultScanner results = table.getScanner(scan);  
        for (Result result : results) {  
            for (Cell cell : result.rawCells()) {  
                System.out.println(  
                        "行键:" + new String(CellUtil.cloneRow(cell)) + "\t" +  
                        "列族:" + new String(CellUtil.cloneFamily(cell)) + "\t" +   
                        "列名:" + new String(CellUtil.cloneQualifier(cell)) + "\t" +   
                        "值:" + new String(CellUtil.cloneValue(cell)) + "\t" +  
                        "时间戳:" + cell.getTimestamp());  
            }  
        }  
        // 关闭资源  
        results.close();  
        table.close();  
        conn.close();  
        System.out.println("finished....");
          
    }  
    
    
}  

