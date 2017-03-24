package org.lvzr.fast.java.thread;

import org.junit.Test;

public class Tests{
	
	@Test
	public void testMyThread(){
		for (int i = 0; i < 100; i++) {
			Thread myThread1 = new MyThread();  
			myThread1.start();
		}
	}
	
	@Test
	public void testMyRunnable(){
		for (int i = 0; i < 100; i++) {
			MyRunnable myRunnable1 = new MyRunnable();  
			Thread thread1 = new Thread(myRunnable1);
			thread1.start();
		}
	}
		
}