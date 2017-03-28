package org.lvzr.fast.bigdata.hbase;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;  
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;  
import org.apache.hadoop.hbase.HColumnDescriptor;  
import org.apache.hadoop.hbase.HTableDescriptor;  
import org.apache.hadoop.hbase.TableName;  
import org.apache.hadoop.hbase.client.Connection;  
import org.apache.hadoop.hbase.client.ConnectionFactory;  
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
  
    public static void main(String[] args) throws IOException {  
         Configuration conf = HBaseConfiguration.create();  
        conf.addResource("hbase-site.xml");

         Connection conn = ConnectionFactory.createConnection(conf);  

        HTable table = (HTable) conn.getTable(TableName.valueOf(TABLE_NAME));  

        Scan scan = new Scan();  

        //Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes("abc")));  

        //scan.setFilter(filter);  

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

        results.close();  
        table.close();  
        conn.close();  
        System.out.println("finished....");
          
    }  
  
}  

