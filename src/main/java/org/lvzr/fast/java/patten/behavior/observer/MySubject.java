package org.lvzr.fast.java.patten.behavior.observer;


public class MySubject extends AbstractSubject {  
 
    public void operation() {  
        System.out.println("update self!");  
        notifyObservers();  
    }  
  
}  

