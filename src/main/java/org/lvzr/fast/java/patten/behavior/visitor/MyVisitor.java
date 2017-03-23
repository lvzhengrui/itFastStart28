package org.lvzr.fast.java.patten.behavior.visitor;

public class MyVisitor implements Visitor {  
 
    public void visitAction(Subject sub) {  
        System.out.println("visit the subject£º"+sub.getSubjectText());  
    }  
    
}  

