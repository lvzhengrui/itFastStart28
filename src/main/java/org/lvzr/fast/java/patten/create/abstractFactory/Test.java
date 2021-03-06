package org.lvzr.fast.java.patten.create.abstractFactory;

import org.lvzr.fast.java.patten.create.factoryMethod.Sender;

/**
 2、抽象工厂模式（Abstract Factory）
   工厂方法模式有一个问题就是，类的创建依赖工厂类，也就是说，如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则，
   所以，从设计角度考虑，有一定的问题，如何解决？就用到抽象工厂模式，创建多个工厂类，
   这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。因为抽象工厂不太好理解，
   我们先看看图，然后就和代码，就比较容易理解。
  
 * 其实这个模式的好处就是，如果你现在想增加一个功能：发及时信息，则只需做一个实现类，
 * 实现Sender接口，同时做一个工厂类，实现Provider接口，就OK了，
 * 无需去改动现成的代码。这样做，拓展性较好！
 * 
 * 
 * 所谓抽象工厂模式，即对工厂类进行抽象，所以根据不同具体产品类，就会对应一个具体工厂类
 */
public class Test {  
  
    public static void main(String[] args) {  
    	//工厂接口
        Provider provider = new SendMailFactory();  
        Sender sender = provider.produce();  
        sender.Send();  
    }  
    
}  

