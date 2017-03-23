package org.lvzr.fast.java.patten.behavior.observer;

import java.util.Enumeration;
import java.util.Vector;

public abstract class AbstractSubject implements Subject {  
  
    private Vector<Observer> vector = new Vector<Observer>();  

    public void add(Observer observer) {  
        vector.add(observer);  
    }  
  
    public void del(Observer observer) {  
        vector.remove(observer);  
    }  
  
    public void notifyObservers() {  
        Enumeration<Observer> enumo = vector.elements();  
        while(enumo.hasMoreElements()){  
            enumo.nextElement().update();  
        }  
    }  
    
}  

