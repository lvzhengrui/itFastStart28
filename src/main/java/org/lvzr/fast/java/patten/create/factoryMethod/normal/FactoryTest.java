package org.lvzr.fast.java.patten.create.factoryMethod.normal;

import org.lvzr.fast.java.patten.create.factoryMethod.Sender;

/**
 * 1.1普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。首先看下关系图：
 *
 */
public class FactoryTest {  
  
    public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produce("sms");  
        sender.Send();  
    }  
    
}  

