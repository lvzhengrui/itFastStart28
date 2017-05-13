package org.lvzr.fast.java.thread.join;

public class TestJosin {
	
	public static void main(String[] args) {

		MyThread2 t1 = new MyThread2("TestJoin");
		
		//t1.setDaemon(true);
		
		t1.start();
		
		try {
			t1.join(200); // join()合并线程，主线程等待子线程t1运行200毫秒之后，才开始执行
			//t1.join(); // join()合并线程，主线程等待子线程t1全部运行完之后，才开始执行
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++){
			System.out.println("I am Main Thread");
		}
		
	}
	
}

class MyThread2 extends Thread {

	MyThread2(String s) {
		super(s);
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("I am " + getName());
			try {
				sleep(100); // 暂停，每100毫秒输出一次
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}
