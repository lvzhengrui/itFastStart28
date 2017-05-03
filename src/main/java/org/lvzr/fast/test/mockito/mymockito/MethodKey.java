package org.lvzr.fast.test.mockito.mymockito;

import java.lang.reflect.Method;  
import java.util.Arrays;  
  
public class MethodKey {  
	
    private MyMockCglib myMockCglib;  
    
    private Method method;  
    
    private Object[] args;  
    
    public MethodKey(MyMockCglib myMockCglib, Method method, Object[] args){
    	this.myMockCglib = myMockCglib;
    	this.method = method;
    	this.args = args;
    }
    
    @Override  
    public String toString() {  
        return "{interceptor: " + myMockCglib + ", Method: " 
        		+ method + ", args: " + Arrays.toString(args) + "}";  
    }  
      
    @Override  
    public boolean equals(final Object other) {  
        if (other instanceof MethodKey) {  
            final MethodKey otherMethodInfo = (MethodKey)other;  
            return myMockCglib.equals(otherMethodInfo.myMockCglib) 
            		&& method.equals(otherMethodInfo.method) && Arrays.equals(args, otherMethodInfo.args);  
        }            
        return false;  
    }  
      
    @Override  
    public int hashCode() {  
        return myMockCglib.hashCode() + method.hashCode() + Arrays.hashCode(args);  
    }  
}  


