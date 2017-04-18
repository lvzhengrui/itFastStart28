
###java并发编程--Executor框架(一)
http://www.cnblogs.com/MOBIN/p/5436482.html

###java并发编程-Executor框架
http://www.iteye.com/topic/366591/

###Java 线程池架构原理和源码解析(ThreadPoolExecutor)
http://developer.51cto.com/art/201510/493465.htm


-------------------------------------------
###Executor
Executor：一个接口，其定义了一个接收Runnable对象的方法executor，其方法签名为executor(Runnable command),
 
ExecutorService：是一个比Executor使用更广泛的子类接口，其提供了生命周期管理的方法，以及可跟踪一个或多个异步任务执行状况返回Future的方法
 
AbstractExecutorService：ExecutorService执行方法的默认实现
 
ScheduledExecutorService：一个可定时调度任务的接口
 
ScheduledThreadPoolExecutor：ScheduledExecutorService的实现，一个可定时调度任务的线程池
 
ThreadPoolExecutor：线程池，可以通过调用Executors以下静态工厂方法来创建线程池并返回一个ExecutorService对象：


--------------------------------------------
###Executors创建线程池
Executors类，提供了一系列工厂方法用于创先线程池，返回的线程池都实现了ExecutorService接口。

public static ExecutorService newFixedThreadPool(int nThreads)
创建固定数目线程的线程池。

public static ExecutorService newCachedThreadPool()
创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。
终止并从缓存中移除那些已有 60 秒钟未被使用的线程。

public static ExecutorService newSingleThreadExecutor()
创建一个单线程化的Executor。

public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)
创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。


---------------------------------------------
###ThreadPoolExecutor
ThreadPoolExecutor(int corePoolSize, int maximumPoolSize,long keepAliveTime, TimeUnit unit,
	BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)

corePoolSize： 线程池维护线程的最少数量
maximumPoolSize：线程池维护线程的最大数量
keepAliveTime： 线程池维护线程所允许的空闲时间
unit： 线程池维护线程所允许的空闲时间的单位

workQueue： 线程池所使用的缓冲队列
  当运行的线程数少于corePoolSize时，在有新任务时直接创建新线程来执行任务而无需再进队列
  当运行的线程数等于或多于corePoolSize，在有新任务添加时则选加入队列，不直接创建线程
  当队列满时，在有新任务时就创建新线程
threadFactory：是构造Thread的方法，你可以自己去包装和传递，主要实现newThread方法即可；
handler： 线程池对拒绝任务的处理策略


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





