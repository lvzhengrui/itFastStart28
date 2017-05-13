package org.lvzr.fast.java.thread.join;

public class TestJosin {
	
	public static void main(String[] args) {

		MyThread2 t1 = new MyThread2("TestJoin");
		
		//t1.setDaemon(true);
		
		t1.start();
		
		try {
			t1.join(200); // join()�ϲ��̣߳����̵߳ȴ����߳�t1����200����֮�󣬲ſ�ʼִ��
			//t1.join(); // join()�ϲ��̣߳����̵߳ȴ����߳�t1ȫ��������֮�󣬲ſ�ʼִ��
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
				sleep(100); // ��ͣ��ÿ100�������һ��
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}
