package org.lvzr.fast.test.unitils;

import org.junit.Test;
import org.lvzr.fast.test.unitils.model.Employee;
import org.unitils.reflectionassert.ReflectionAssert;

public class TestUnitils{ 
 
    /**
     * ���÷�������
     * @return
     */
    @Test
    public void testUnitilsApi(){
    	//�������
        ReflectionAssert.assertReflectionEquals(new Employee("id1","name1"), new Employee("id1","name1"));  
        
    }
 
    
    
}