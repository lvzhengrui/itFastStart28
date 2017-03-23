package org.lvzr.fast.java.patten.behavior.visitor;

public class MySubject implements Subject {  
  
    public void acceptAction(Visitor visitor) {  
        visitor.visitAction(this);  
    }  

    public String getSubjectText() {  
        return "love";  
    }  
}  

