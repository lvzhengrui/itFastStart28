 ###java���߳��е�join�������
 
 http://blog.csdn.net/studyvcmfc/article/details/7426385
 
 
 ����Join�Ǹ�ɶ�õģ� �򵥻ش�ͬ�������ͬ���� ��ôʵ�ֵģ� ���潫����ش�

    �ԴӽӴ�Java���̣߳�һֱ��Join��ⲻ�ˡ�JDK������˵�ģ�join public final void join��long millis��
    throws InterruptedException Waits at most millis milliseconds for this thread to die. A timeout of 
    0 means to wait forever.
    ���������� ������˼�ǵȴ�һ��ʱ��ֱ������߳��������ҵ��������Ǹ��̣߳�����������̻߳��ǵ��������̵߳ģ��ϴ��룺 

package concurrentstudy;
/**
 *
 * @author vma
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread t = new Thread(new RunnableImpl());
        t.start();
        try {
            t.join(1000);
            System.out.println("joinFinish");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
     
        }
    }
}
class RunnableImpl implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Begin sleep");
            Thread.sleep(1000);
           System.out.println("End sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
����ǣ�
Begin sleep
End sleep
joinFinish

�����˰ɣ���main�̵߳���t.joinʱ��main�̵߳ȴ�t�̣߳��ȴ�ʱ����1000�����t�߳�Sleep 2000�� 
 public void run() {
        try {
            System.out.println("Begin sleep");
            // Thread.sleep(1000);
            Thread.sleep(2000);
           System.out.println("End sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
����ǣ�
Begin sleep
joinFinish
End sleep

Ҳ����˵main�߳�ֻ��1000���룬����Tʲôʱ������������t.join()�أ� �����룺   
 public final void join() throws InterruptedException {
    join(0);
    }
    ����˵�����t.join() = t.join(0) 0��JDK����˵�� A timeout of 0 means to wait forever ������˼����Զ�ȴ�����������
    ��ʵ�ǵȵ�t������
    �������ôʵ�ֵ��� ��JDK���룺

    /**
     * Waits at most <code>millis</code> milliseconds for this thread to 
     * die. A timeout of <code>0</code> means to wait forever. 
     *
     * @param      millis   the time to wait in milliseconds.
     * @exception  InterruptedException if any thread has interrupted
     *             the current thread.  The <i>interrupted status</i> of the
     *             current thread is cleared when this exception is thrown.
     */
    public final synchronized void join(long millis) throws InterruptedException {
    	long base = System.currentTimeMillis();
    	long now = 0;

    	if (millis < 0) {
    		throw new IllegalArgumentException("timeout value is negative");
    	}

    	if (millis == 0) {
        	while (isAlive()) {
        		wait(0);
        	}
    	} else {
        	while (isAlive()) {
        		long delay = millis - now;
        		if (delay <= 0) {
            		break;
        		}
        		wait(delay);
        		now = System.currentTimeMillis() - base;
        	}
    	}
    }
    ��ʵJoin����ʵ����ͨ��wait��С��ʾ��Object �ṩ�ķ������� ��main�̵߳���t.joinʱ��main�̻߳����̶߳���t����
    ��wait ��ζ���õ��ö������),���øö����wait(�ȴ�ʱ��)��ֱ���ö�����main�̣߳������˳���

    �����ζ��main �̵߳���t.joinʱ�������ܹ��õ��߳�t�������������ò��������޷�wait�ģ��տ�������t.join(1000)����˵����
    main�̵߳ȴ�1 �룬��������ȴ�֮ǰ�������̻߳�ȡ��t������������ȴ�ʱ��ɲ�����1�����ˡ��ϴ�����ܣ�

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentstudy;
/**
 *
 * @author vma
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread t = new Thread(new RunnableImpl());
        
        new ThreadTest(t).start();
        
        t.start();
        
        try {
            t.join();
            System.out.println("joinFinish");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
     
        }
    }
}
class ThreadTest extends Thread {

    Thread thread;

    public ThreadTest(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        holdThreadLock();
    }

    public void holdThreadLock() {
        synchronized (thread) {
            System.out.println("getObjectLock");
            try {
                Thread.sleep(9000);

            } catch (InterruptedException ex) {
             ex.printStackTrace();
            }
            System.out.println("ReleaseObjectLock");
        }

    }
}

class RunnableImpl implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Begin sleep");
            Thread.sleep(2000);
            System.out.println("End sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
    ��main������ ͨ��new ThreadTest(t).start();ʵ����ThreadTest �̶߳��� ����holdThreadLock()�����У�
    ͨ�� synchronized (thread)����ȡ�̶߳���t��������Sleep��9000�����ͷţ������ζ�ţ���ʹ
main����t.join(1000),�ȴ�һ���ӣ�������ȴ�ThreadTest �߳��ͷ�t������ܽ���wait�����У���ʵ�ʵȴ�ʱ����9000+1000 MS
���н���ǣ�
getObjectLock
Begin sleep
End sleep
ReleaseObjectLock
joinFinish

ת�ԣ�http://java.chinaitlab.com/JDK/760879.html

  

ps��

����ΪʲôҪ��join()����

���߳����ɲ��������̣߳������߳���Ҫ���д����ĺ�ʱ������(������Խ�����̵߳�����)�������̴߳����������������
��Ҫ�õ����̵߳Ĵ����������ʱ���Ҫ�õ�join();�����ˡ�
 

����join����������

�����Ͽ�������˵���������̺߳ϲ��������������Ҿ���������������鷳������ͽ����API���˵����

���ȴ����߳���ֹ����

����һ�£������߳�(���ڡ�һ�����Ѿ���������)�ȴ����̵߳���ֹ��Ҳ���������̵߳�����join()��������Ĵ��룬
ֻ�еȵ����߳̽����˲���ִ�С�(Waits for this thread to die.)

 

 

�ġ���ʵ�������

дһ���򵥵���������һ��join()���÷���һ�������ࣺ

1.CustomThread ��

2. CustomThread1��

3. JoinTestDemo �࣬main�������ڵ��ࡣ

 

����1��

package wxhx.csdn2;  
/** 
 *  
 * @author bzwm 
 * 
 */  
class CustomThread1 extends Thread {  
    public CustomThread1() {  
        super("[CustomThread1] Thread");  
    };  
    public void run() {  
        String threadName = Thread.currentThread().getName();  
        System.out.println(threadName + " start.");  
        try {  
            for (int i = 0; i < 5; i++) {  
                System.out.println(threadName + " loop at " + i);  
                Thread.sleep(1000);  
            }  
            System.out.println(threadName + " end.");  
        } catch (Exception e) {  
            System.out.println("Exception from " + threadName + ".run");  
        }  
    }  
}  
class CustomThread extends Thread {  
    CustomThread1 t1;  
    public CustomThread(CustomThread1 t1) {  
        super("[CustomThread] Thread");  
        this.t1 = t1;  
    }  
    public void run() {  
        String threadName = Thread.currentThread().getName();  
        System.out.println(threadName + " start.");  
        try {  
            t1.join();  
            System.out.println(threadName + " end.");  
        } catch (Exception e) {  
            System.out.println("Exception from " + threadName + ".run");  
        }  
    }  
}  
public class JoinTestDemo {  
    public static void main(String[] args) {  
        String threadName = Thread.currentThread().getName();  
        System.out.println(threadName + " start.");  
        CustomThread1 t1 = new CustomThread1();  
        CustomThread t = new CustomThread(t1);  
        try {  
            t1.start();  
            Thread.sleep(2000);  
            t.start();  
            t.join();//�ڴ��a2�����̎עጵ�  
        } catch (Exception e) {  
            System.out.println("Exception from main");  
        }  
        System.out.println(threadName + " end!");  
    }  
}  

 
��ӡ�����


main start.//main�������ڵ��߳��𶯣���û�����Ͻ�������Ϊ����t.join();������Ҫ�ȵ�t�����ˣ����̲߳�������ִ�С�

[CustomThread1] Thread start.//�߳�CustomThread1��

[CustomThread1] Thread loop at 0//�߳�CustomThread1ִ��

[CustomThread1] Thread loop at 1//�߳�CustomThread1ִ��

[CustomThread] Thread start.//�߳�CustomThread�𶯣���û�����Ͻ�������Ϊ����t1.join();������Ҫ�ȵ�t1�����ˣ����̲߳�������ִ�С�

[CustomThread1] Thread loop at 2//�߳�CustomThread1����ִ��

[CustomThread1] Thread loop at 3//�߳�CustomThread1����ִ��

[CustomThread1] Thread loop at 4//�߳�CustomThread1����ִ��

[CustomThread1] Thread end. //�߳�CustomThread1������

[CustomThread] Thread end.// �߳�CustomThread��t1.join();�������𶯣����¼���ִ�еĽ��

main end!//�߳�CustomThread���������߳���t.join();�������𶯣����¼���ִ�еĽ����

 

�޸�һ�´��룬�õ�����2��(����ֻд���޸ĵĲ���)

public class JoinTestDemo {  
    public static void main(String[] args) {  
        String threadName = Thread.currentThread().getName();  
        System.out.println(threadName + " start.");  
        CustomThread1 t1 = new CustomThread1();  
        CustomThread t = new CustomThread(t1);  
        try {  
            t1.start();  
            Thread.sleep(2000);  
            t.start();  
//          t.join();//�ڴ��a2�����̎עጵ�  
        } catch (Exception e) {  
            System.out.println("Exception from main");  
        }  
        System.out.println(threadName + " end!");  
    }  
}  
��ӡ�����

 

main start. // main�������ڵ��߳��𶯣���û�����Ͻ��������ﲢ������Ϊjoin������������ΪThread.sleep(2000);

[CustomThread1] Thread start. //�߳�CustomThread1��

[CustomThread1] Thread loop at 0//�߳�CustomThread1ִ��

[CustomThread1] Thread loop at 1//�߳�CustomThread1ִ��

main end!// Thread.sleep(2000);��������Ȼ���߳�CustomThreadִ����t1.join();�����Ⲣ����Ӱ�쵽�����߳�(����main�������ڵ��߳�)��

[CustomThread] Thread start. //�߳�CustomThread�𶯣���û�����Ͻ�������Ϊ����t1.join();������Ҫ�ȵ�t1�����ˣ����̲߳�������ִ�С�

[CustomThread1] Thread loop at 2//�߳�CustomThread1����ִ��

[CustomThread1] Thread loop at 3//�߳�CustomThread1����ִ��

[CustomThread1] Thread loop at 4//�߳�CustomThread1����ִ��

[CustomThread1] Thread end. //�߳�CustomThread1������

[CustomThread] Thread end. // �߳�CustomThread��t1.join();�������𶯣����¼���ִ�еĽ��

 

 

�塢��Դ�뿴join()����

 

��CustomThread��run�����ִ����t1.join();�����뿴һ������JDKԴ�룺

public final void join() throws InterruptedException {  
n(0);  
}  
Ȼ�����join(0)������

   /** 
    * Waits at most <code>millis</code> milliseconds for this thread to  
    * die. A timeout of <code>0</code> means to wait forever. //ע����� 
    * 
    * @param      millis   the time to wait in milliseconds. 
    * @exception  InterruptedException if another thread has interrupted 
    *             the current thread.  The <i>interrupted status</i> of the 
    *             current thread is cleared when this exception is thrown. 
    */  
   public final synchronized void join(long millis) //����millisΪ0.  
   throws InterruptedException {  
long base = System.currentTimeMillis();  
long now = 0;  
if (millis < 0) {  
           throw new IllegalArgumentException("timeout value is negative");  
}  
if (millis == 0) {//���������֧  
    while (isAlive()) {//�жϱ��߳��Ƿ�Ϊ��ġ�����ı��߳̾���t1.  
    wait(0);//����  
    }  
} else {  
    while (isAlive()) {  
    long delay = millis - now;  
    if (delay <= 0) {  
        break;  
    }  
    wait(delay);  
    now = System.currentTimeMillis() - base;  
    }  
}  
   }  

 

�����Ӵ����Ͽ�������̱߳������ˣ�����δ���𶯣���������join()������û�����õġ���ֱ�Ӽ�������ִ�У�����Ͳ�д������֤�ˡ�

 
 
 