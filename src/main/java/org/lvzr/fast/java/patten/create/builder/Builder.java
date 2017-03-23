package org.lvzr.fast.java.patten.create.builder;

import java.util.ArrayList;
import java.util.List;

import org.lvzr.fast.java.patten.create.factoryMethod.MailSender;
import org.lvzr.fast.java.patten.create.factoryMethod.Sender;
import org.lvzr.fast.java.patten.create.factoryMethod.SmsSender;


public class Builder {  
      
    private List<Sender> list = new ArrayList<Sender>();  
      
    public void produceMailSender(int count){  
        for(int i=0; i<count; i++){  
            list.add(new MailSender());  
        }  
    }  
      
    public void produceSmsSender(int count){  
        for(int i=0; i<count; i++){  
            list.add(new SmsSender());  
        }  
    }  
    
}  

