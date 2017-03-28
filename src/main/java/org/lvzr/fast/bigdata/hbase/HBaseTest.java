package org.lvzr.fast.bigdata.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
 
public class HBaseTest {
	
	static Configuration cfg = HBaseConfiguration.create();
	
    static{
        cfg.addResource("hbase-site.xml");
    }
    
 	public static void create(String tableName, String columnFamily) throws Exception{
		HBaseAdmin admin = new HBaseAdmin(cfg);
		if(admin.tableExists(tableName)){
			System.out.println("Table exist");
			System.exit(0);
		}
		else {
			HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
			tableDescriptor.addFamily(new HColumnDescriptor(columnFamily));
			admin.createTable(tableDescriptor);
			System.out.println("Table create success");
		}
	}
	
 	public static void put(String tableName,String row,String columnFamily,String column,String data) throws IOException{
		HTable table = new HTable(cfg, tableName);
		Put put = new Put(Bytes.toBytes(row));
		put.add(Bytes.toBytes(columnFamily),Bytes.toBytes(column),Bytes.toBytes(data));
		table.put(put);
		System.out.println("put success");
	}
	
 	public static void get(String tableName,String row) throws IOException{
		HTable table = new HTable(cfg, tableName);
		Get get = new Get(Bytes.toBytes(row));
		Result result = table.get(get);
		System.out.println("get "+ result);	
	}
	
 	public static void scan (String tableName) throws IOException{
		HTable table = new HTable(cfg, tableName);
		Scan scan = new Scan();
		ResultScanner resultScanner = table.getScanner(scan);
		for(Result s:resultScanner){
			System.out.println("Scan "+ resultScanner);
		}
	}
	
	public static boolean delete(String tableName) throws Exception{
		HBaseAdmin admin = new HBaseAdmin(cfg);
		if(admin.tableExists(tableName)){
			try {
				admin.disableTable(tableName);
				admin.deleteTable(tableName);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String tableName = "hbase_test2";
		String columnFamily = "c1";
		
		try {
			HBaseTest.create(tableName, columnFamily);
			HBaseTest.put(tableName, "row1", columnFamily, "column1", "data1");
			HBaseTest.get(tableName, "row1");
			HBaseTest.scan(tableName);
			//if(HBaseTest.delete(tableName)==true){
			//	System.out.println("delete table "+ tableName+"success");
			//}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
 