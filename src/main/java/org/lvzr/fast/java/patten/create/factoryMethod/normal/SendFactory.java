package org.lvzr.fast.java.patten.create.factoryMethod.normal;

import org.lvzr.fast.java.patten.create.factoryMethod.MailSender;
import org.lvzr.fast.java.patten.create.factoryMethod.Sender;
import org.lvzr.fast.java.patten.create.factoryMethod.SmsSender;

public class SendFactory {  
	  
    public Sender produce(String type) {  
        if ("mail".equals(type)) {  
            return new MailSender();  
        } else if ("sms".equals(type)) {  
            return new SmsSender();  
        } else {  
            System.out.println("请输入正确的类型!");  
            return null;  
        }  
    }  
}  

