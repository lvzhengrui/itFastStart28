package org.lvzr.fast.java.patten.create.abstractFactory;

import org.lvzr.fast.java.patten.create.factoryMethod.MailSender;
import org.lvzr.fast.java.patten.create.factoryMethod.Sender;

public class SendMailFactory implements Provider {  
 
    public Sender produce(){  
        return new MailSender();  
    }  
    
}  

