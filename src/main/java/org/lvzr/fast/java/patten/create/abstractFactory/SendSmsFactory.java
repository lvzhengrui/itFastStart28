package org.lvzr.fast.java.patten.create.abstractFactory;

import org.lvzr.fast.java.patten.create.factoryMethod.Sender;
import org.lvzr.fast.java.patten.create.factoryMethod.SmsSender;

public class SendSmsFactory implements Provider{  
 
    public Sender produce() {  
        return new SmsSender();  
    }  
    
}  

