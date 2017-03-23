package org.lvzr.fast.java.patten.behavior.chain;

/**
  17��������ģʽ��Chain of Responsibility��
     ���������ǽ�Ҫ̸̸������ģʽ���ж������ÿ��������ж���һ����������ã������ͻ��γ�һ������
     �������������ϴ��ݣ�ֱ��ĳһ���������������󡣵��Ƿ����߲���������������Ǹ�����ᴦ�������
    ���ԣ�������ģʽ����ʵ�֣��������ͻ��˵�����£���ϵͳ���ж�̬�ĵ������ȿ�����ϵͼ��

  Abstracthandler���ṩ��get��set����������MyHandle�����ú��޸����ö���MyHandle���Ǻ��ģ�
    ʵ����������һϵ���໥���еĶ��󣬹���һ������
	
   �˴�ǿ��һ����ǣ������ϵ����������һ������������һ��������������һ������
   ģʽ����Լ���������Ҫ�����Լ�ȥʵ�֣�ͬʱ����һ��ʱ�̣�
   ����ֻ������һ�����󴫸���һ�����󣬶����������������
*/

public class Test {  
	  
    public static void main(String[] args) {  
        MyHandler h1 = new MyHandler("h1");  
        MyHandler h2 = new MyHandler("h2");  
        MyHandler h3 = new MyHandler("h3");  
  
        h1.setHandler(h2);  
        h2.setHandler(h3);  
  
        h1.operator();  
    }  
}  

