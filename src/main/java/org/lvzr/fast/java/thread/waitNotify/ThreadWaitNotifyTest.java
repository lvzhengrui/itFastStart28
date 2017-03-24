package org.lvzr.fast.java.thread.waitNotify;

import java.util.Vector;

/**
 * 生产者－－消费者，二者共享数据goods(vector对象），这里，生产者是Producter, 消费者是Consumer。
 * 生产者负责放物品到goods中，消费者使用wait( )等待生产者的通知。当得到通知后，消费者取出物品，
 * 并且用notify( )通知生产者，可以再放下一批物品。
 */
public class ThreadWaitNotifyTest {
	public static void main(String args[]) {
		Vector obj = new Vector();
		Thread consumer = new Thread(new Consumer(obj));
		Thread producter = new Thread(new Producter(obj));
		consumer.start();
		producter.start();
	}
}

/* 消费者 */
class Consumer implements Runnable {
	private Vector obj;

	public Consumer(Vector v) {
		this.obj = v;
	}

	public void run() {
		synchronized (obj) {
			while (true) {
				try {
					if (obj.size() == 0) {
						obj.wait();
					}
					System.out.println("Consumer:goods have been taken");
					System.out.println("obj size: " + obj.size());
					obj.clear();
					obj.notify();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

/* 生产者 */
class Producter implements Runnable {
	private Vector obj;

	public Producter(Vector v) {
		this.obj = v;
	}

	public void run() {
		synchronized (obj) {
			while (true) {
				try {
					if (obj.size() != 0) {
						obj.wait();
					}

					obj.add(new String("apples"));
					obj.notify();
					System.out.println("Producter:obj are ready");
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
