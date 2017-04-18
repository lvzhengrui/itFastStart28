
###java�������--Executor���(һ)
http://www.cnblogs.com/MOBIN/p/5436482.html

###java�������-Executor���
http://www.iteye.com/topic/366591/

###Java �̳߳ؼܹ�ԭ���Դ�����(ThreadPoolExecutor)
http://developer.51cto.com/art/201510/493465.htm


-------------------------------------------
###Executor
Executor��һ���ӿڣ��䶨����һ������Runnable����ķ���executor���䷽��ǩ��Ϊexecutor(Runnable command),
 
ExecutorService����һ����Executorʹ�ø��㷺������ӿڣ����ṩ���������ڹ���ķ������Լ��ɸ���һ�������첽����ִ��״������Future�ķ���
 
AbstractExecutorService��ExecutorServiceִ�з�����Ĭ��ʵ��
 
ScheduledExecutorService��һ���ɶ�ʱ��������Ľӿ�
 
ScheduledThreadPoolExecutor��ScheduledExecutorService��ʵ�֣�һ���ɶ�ʱ����������̳߳�
 
ThreadPoolExecutor���̳߳أ�����ͨ������Executors���¾�̬���������������̳߳ز�����һ��ExecutorService����


--------------------------------------------
###Executors�����̳߳�
Executors�࣬�ṩ��һϵ�й����������ڴ����̳߳أ����ص��̳߳ض�ʵ����ExecutorService�ӿڡ�

public static ExecutorService newFixedThreadPool(int nThreads)
�����̶���Ŀ�̵߳��̳߳ء�

public static ExecutorService newCachedThreadPool()
����һ���ɻ�����̳߳أ�����execute ��������ǰ������̣߳�����߳̿��ã�����������߳�û�п��õģ��򴴽�һ�����̲߳���ӵ����С�
��ֹ���ӻ������Ƴ���Щ���� 60 ����δ��ʹ�õ��̡߳�

public static ExecutorService newSingleThreadExecutor()
����һ�����̻߳���Executor��

public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)
����һ��֧�ֶ�ʱ�������Ե�����ִ�е��̳߳أ���������¿��������Timer�ࡣ


---------------------------------------------
###ThreadPoolExecutor
ThreadPoolExecutor(int corePoolSize, int maximumPoolSize,long keepAliveTime, TimeUnit unit,
	BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)

corePoolSize�� �̳߳�ά���̵߳���������
maximumPoolSize���̳߳�ά���̵߳��������
keepAliveTime�� �̳߳�ά���߳�������Ŀ���ʱ��
unit�� �̳߳�ά���߳�������Ŀ���ʱ��ĵ�λ

workQueue�� �̳߳���ʹ�õĻ������
  �����е��߳�������corePoolSizeʱ������������ʱֱ�Ӵ������߳���ִ������������ٽ�����
  �����е��߳������ڻ����corePoolSize���������������ʱ��ѡ������У���ֱ�Ӵ����߳�
  ��������ʱ������������ʱ�ʹ������߳�
threadFactory���ǹ���Thread�ķ�����������Լ�ȥ��װ�ʹ��ݣ���Ҫʵ��newThread�������ɣ�
handler�� �̳߳ضԾܾ�����Ĵ������


-------------------------------------------------
Executor executor = Executors.newFixedThreadPool(10);  
Runnable task = new Runnable() {  
    @Override  
    public void run() {  
        System.out.println("task over");  
    }  
};  
executor.execute(task);  


executor = Executors.newScheduledThreadPool(10);  
ScheduledExecutorService scheduler = (ScheduledExecutorService) executor;  
scheduler.scheduleAtFixedRate(task, 10, 10, TimeUnit.SECONDS);  





