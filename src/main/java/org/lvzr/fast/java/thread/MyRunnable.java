package org.lvzr.fast.java.thread;

public class MyRunnable implements Runnable {
	
	private int i = 0;

	public void run() {
		for (i = 0; i < 100; i++) {
			System.out.println("MyRunnable "+Thread.currentThread().getName() + " " + i);
		}
	}
	
}
