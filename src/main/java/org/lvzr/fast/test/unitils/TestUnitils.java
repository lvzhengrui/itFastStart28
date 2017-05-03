package org.lvzr.fast.test.unitils;

import org.junit.Test;
import org.lvzr.fast.test.unitils.model.Employee;
import org.unitils.reflectionassert.ReflectionAssert;

public class TestUnitils{ 
 
    /**
     * 常用方法测试
     * @return
     */
    @Test
    public void testUnitilsApi(){
    	//反射断言
        ReflectionAssert.assertReflectionEquals(new Employee("id1","name1"), new Employee("id1","name1"));  
        
    }
 
    
    
}