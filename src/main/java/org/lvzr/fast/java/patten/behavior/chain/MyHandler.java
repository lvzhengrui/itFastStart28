package org.lvzr.fast.java.patten.behavior.chain;

public class MyHandler extends AbstractHandler implements Handler {  
  
    private String name;  
  
    public MyHandler(String name) {  
        this.name = name;  
    }  

    public void operator() {  
        System.out.println(name+"deal!");  
        if(getHandler()!=null){  
            getHandler().operator();  
        }  
    }  
}  


