package org.lvzr.fast.java.patten.create.factoryMethod.mutiltion;

import org.lvzr.fast.java.patten.create.factoryMethod.Sender;
 
/**
 * 1.2�����������ģʽ���Ƕ���ͨ��������ģʽ�ĸĽ�������ͨ��������ģʽ�У�������ݵ��ַ�������
 * ������ȷ�������󣬶������������ģʽ���ṩ��������������ֱ𴴽����󡣹�ϵͼ��
 *
 */
public class FactoryTest {  
  
    public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produceMail();  
        sender.Send();  
    }  
    
}  

