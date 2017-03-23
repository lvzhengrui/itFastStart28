package org.lvzr.fast.java.patten.behavior.visitor;

public interface Subject {  
    
	public void acceptAction(Visitor visitor);  
    
	public String getSubjectText();  
    
}  

