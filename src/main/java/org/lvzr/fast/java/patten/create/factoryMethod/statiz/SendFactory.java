package org.lvzr.fast.java.patten.create.factoryMethod.statiz;

import org.lvzr.fast.java.patten.create.factoryMethod.MailSender;
import org.lvzr.fast.java.patten.create.factoryMethod.Sender;
import org.lvzr.fast.java.patten.create.factoryMethod.SmsSender;

public class SendFactory {  
      
    public static Sender produceMail(){  
        return new MailSender();  
    }  
      
    public static Sender produceSms(){  
        return new SmsSender();  
    }  
}  

