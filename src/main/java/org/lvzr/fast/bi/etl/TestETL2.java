package org.lvzr.fast.bi.etl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * 
 * @author lvzr
 */
public class TestETL2{

	private static Executor executor = Executors.newFixedThreadPool(100);  
	 
	/**
	 * –¥»Îmogodb
	 * @param filePathe
	 */
	public void writeToMongoDB (String filePath) {
		try {						
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
				//–¥»ÎDB
				executor.execute(new ExeTask(newObject));
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
 
	public class ExeTask implements Runnable{

		private DBObject dbObject;
		
		public ExeTask (DBObject dbObject) {
			this.dbObject = dbObject;
		}
		
		public void run() {
			DB db = null;
			try {
				db = MongoDbContext.getDB();
				DBCollection registerCollection = db.getCollection("register");
				registerCollection.insert(dbObject);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					MongoDbContext.releaseDB(db);	
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		}
		
	} 
	
	public static void main(String[] args) {
		
		//TestETL.createNewFile("e:/etl/register.txt", 10*1000*10000, 50);		
		try {			
		
			MongoClient client = new MongoClient("127.0.0.1",27017);
			DB db = client.getDB("test");
			DBCollection registerCollection = db.getCollection("register");
			System.out.println("coll count:"+registerCollection.count());
			registerCollection.drop();
			
			Runnable runnable = new Runnable() {
				public void run() {
					(new TestETL2()).writeToMongoDB("e:/etl/register.txt");
				}
			};
			Thread thread = new Thread(runnable);
			thread.start();			
			System.out.println("exit main");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	  
	static class MongoDbContext{
		
		private static Integer DB_POOL_SIZE = 110;
		
		private static Integer DB_STATE_FREE = 0;
		private static Integer DB_STATE_BUSY = 1;
		
		private static Map<Integer,DB> dbPool = new ConcurrentHashMap<Integer,DB>();
		private static Map<Integer,Integer> dbPoolState = new ConcurrentHashMap<Integer,Integer>();
		
		static{
			for(int i=0; i<DB_POOL_SIZE; i++){
				MongoClient client;
				try {
					client = new MongoClient("127.0.0.1",27017);
					DB db = client.getDB("test");
					dbPool.put(i, db);
					dbPoolState.put(i, DB_STATE_FREE);
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}			
			}			
		}
		
		public static DB getDB(){
			DB db = null;
			try {				
				while(true){
					for(int i=0; i<DB_POOL_SIZE; i++){
						if(dbPoolState.get(i)==DB_STATE_FREE){
							db = dbPool.get(i);			
							dbPoolState.put(i, DB_STATE_BUSY);	
							return db;
						}						
					}
					Thread.sleep(100);
				}	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public static boolean releaseDB(DB db){
			for(int i=0; i<DB_POOL_SIZE; i++){
				DB thisDb = dbPool.get(i);
				if(db == thisDb){		
					dbPoolState.put(i, DB_STATE_FREE);	
				}
			}
			return true;
		}

	}
	
}