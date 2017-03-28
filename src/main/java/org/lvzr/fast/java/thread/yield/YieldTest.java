package org.lvzr.fast.java.thread.yield;

/**  
 * �߳��ò����ñ��߳̽������״̬,�ó�cup�����������߳�  
 * ���ǲ��ų���һ�����еĻ��Ǳ��߳�   
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
                System.out.println("����"+this.getName()+"----------------"+i);       //1  
            }  
        }  
        
    }  
    
    public static void main(String[] args) {  
        YieldTest yt1=new YieldTest("��");  //���ȼ��߲�����ռ������cpuʱ��  
        YieldTest yt2=new YieldTest("��");  
        yt1.setPriority(Thread.MAX_PRIORITY);                   //2  
        yt1.start();  
        yt2.setPriority(Thread.MIN_PRIORITY);                   //2    
        yt2.start(); 
        
    }  
    
}  
