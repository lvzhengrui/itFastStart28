package org.lvzr.fast.bi.etl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

 
/**
 * 
 * @author lvzr
 */
public class TestETL{
 
	private static BlockingQueue<DBObject> blockingQueueLines = new LinkedBlockingQueue<DBObject>(200);
 
	/**
	 * 创建文本文件
	 * 1亿条，50个字段，字段内容fieldN，字段间用\t间隔，文件大小为36G，写入时间10分钟
	 * @param filePath
	 * @param rowNum
	 * @param ColNum
	 * @return
	 */
	public static boolean createNewFile (String filePath,int rowNum,int ColNum) {
		try {
			long startTime = System.currentTimeMillis();
			File file = new java.io.File(filePath);
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for(int i=0;i<rowNum;i++){
			  if(i>0 && i % 10000 == 0){
				  System.out.println((i/10000)+"w time:"+(System.currentTimeMillis()-startTime)/1000+" s");
			  }	
			  for(int j=1;j<=ColNum;j++){
				  bufferedWriter.write("field"+j);
				  bufferedWriter.write("\t");
			  }	
			  bufferedWriter.write("\r\n");
			}
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
		return true;
	}
 
	/**
	 * 写入mogodb
	 * 1365w条数据，50个字段入库mongodb，耗时：47分钟，预计36G的1亿条数据为7个小时
	 * @param filePathe
	 */
	public static void writeToBlockQueue (String filePath) {
		try {
			//MongoClient client = new MongoClient("127.0.0.1",27017);
			//DB db = client.getDB("test");
			//DBCollection registerCollection = db.getCollection("register");
			//System.out.println("coll count:"+registerCollection.count());
			//registerCollection.drop();
			
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			long i=0,iw=0;
			long startTime = System.currentTimeMillis();
			while((line=bufferedReader.readLine())!=null){
				String[] fields = line.split("\t");
				DBObject newObject = new BasicDBObject();
				for(int j=0;j<fields.length;j++){
					newObject.put("xfield_"+(j+1), fields[j]);
				}				
				blockingQueueLines.put(newObject);				
				//registerCollection.insert(newObject);
				i++;
				if(i==10000){
					i=0;
					iw++;
					System.out.println("put Queue"+iw+"w time:"+((System.currentTimeMillis()-startTime)/1000)+"s.");
				}
			}		
			bufferedReader.close();
			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * 
	 */
	public static void queuetoMongodb(){
		try {
			MongoClient client = new MongoClient("127.0.0.1",27017);
			DB db = client.getDB("test");
			DBCollection registerCollection = db.getCollection("register");
			System.out.println("coll count:"+registerCollection.count());
			registerCollection.drop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<100;i++){
			Runnable runnable = new Runnable() {	
				public void run() {
					DBCollection registerCollection = null;
					try {
						MongoClient client  = new MongoClient("127.0.0.1",27017);
						DB db = client.getDB("test");
						registerCollection = db.getCollection("register");
					} catch (Exception e) {
						e.printStackTrace();
					}
					//循环
					while (true) {
						try {
							DBObject newObject = blockingQueueLines.take();
							registerCollection.insert(newObject);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			};
			Thread thread = new Thread(runnable);
			//thread.setDaemon(true);
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		//TestETL.createNewFile("e:/etl/register.txt", 10*1000*10000, 50);		
		try {			
			Runnable runnable = new Runnable() {
				public void run() {
					writeToBlockQueue("e:/etl/register.txt");
				}
			};
			Thread thread = new Thread(runnable);
			//thread.setDaemon(true);
			thread.start();
			
			queuetoMongodb();
			
			System.out.println("exit main");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}