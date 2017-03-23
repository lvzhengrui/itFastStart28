package org.lvzr.fast.java.patten.struct.adapter.clazz;

import org.lvzr.fast.java.patten.struct.adapter.Source;
import org.lvzr.fast.java.patten.struct.adapter.Targetable;

public class Adapter extends Source implements Targetable {  

    public void method2() {  
        System.out.println("this is the targetable method!");  
    }  

}  

