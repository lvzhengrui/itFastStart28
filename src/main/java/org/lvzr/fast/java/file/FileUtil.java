package org.lvzr.fast.java.file;

import java.io.RandomAccessFile;
import java.util.*;

/**
 * 
 * @author lvzr
 */
public class FileUtil{
	
    public static void main(String[] args) {
    	try {
        	RandomAccessFile raf = new RandomAccessFile("e:/test.txt","rw");  
        	raf.seek(raf.length());  
            raf.writeBytes("cccc");  
            raf.close();  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

    }
    
}