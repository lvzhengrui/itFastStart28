package org.lvzr.fast.java.thread.yield;

/**  
 * 线程让步，让本线程进入就绪状态,让出cup来给其他的线程  
 * 但是不排除下一个运行的还是本线程   
 */  
public class YieldTest extends Thread{  
    
	public YieldTest(){  
          
    }  
    
    public YieldTest(String name){  
        super(name);  
    }  
    
    @Override  
    public void run() {  
        for(int i=0;i<=50;i++){  
            System.out.println(""+this.getName()+"-----"+i);  
            if(i==30){  
                this.yield();  
                System.out.println("我是"+this.getName()+"----------------"+i);       //1  
            }  
        }  
        
    }  
    
    public static void main(String[] args) {  
        YieldTest yt1=new YieldTest("高");  //优先级高不代表占用所有cpu时间  
        YieldTest yt2=new YieldTest("低");  
        yt1.setPriority(Thread.MAX_PRIORITY);                   //2  
        yt1.start();  
        yt2.setPriority(Thread.MIN_PRIORITY);                   //2    
        yt2.start(); 
        
    }  
    
}  
