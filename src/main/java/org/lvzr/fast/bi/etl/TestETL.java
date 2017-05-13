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
	 * �����ı��ļ�
	 * 1������50���ֶΣ��ֶ�����fieldN���ֶμ���\t������ļ���СΪ36G��д��ʱ��10����
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