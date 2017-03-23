package org.lvzr.fast.java.patten.create.factoryMethod.normal;

import org.lvzr.fast.java.patten.create.factoryMethod.Sender;

/**
 * 1.1��ͨ����ģʽ�����ǽ���һ�������࣬��ʵ����ͬһ�ӿڵ�һЩ�����ʵ���Ĵ��������ȿ��¹�ϵͼ��
 *
 */
public class FactoryTest {  
  
    public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produce("sms");  
        sender.Send();  
    }  
    
}  

