package org.lvzr.fast.bi.etl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

 
/**
 * 
 * @author lvzr
 */
public class TestETL{
	
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
	
	
	
	public static void main(String[] args) {

		TestETL.createNewFile("e:/etl/register.txt", 10*1000*10000, 50);
		
	}
	
}