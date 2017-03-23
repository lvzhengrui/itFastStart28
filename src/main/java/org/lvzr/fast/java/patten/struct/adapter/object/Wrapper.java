package org.lvzr.fast.java.patten.struct.adapter.object;

import org.lvzr.fast.java.patten.struct.adapter.Source;
import org.lvzr.fast.java.patten.struct.adapter.Targetable;

public class Wrapper implements Targetable {  
  
    private Source source;  
      
    public Wrapper(Source source){  
        super();  
        this.source = source;  
    }  

    public void method2() {  
        System.out.println("this is the targetable method!");  
    }  
  
    public void method1() {  
        source.method1();  
    }  
}  

