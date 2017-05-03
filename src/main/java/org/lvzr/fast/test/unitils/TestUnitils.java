package org.lvzr.fast.test.unitils;

import java.util.List;

import org.junit.Test;
import org.lvzr.fast.test.powermock.complex.Employee;
import org.lvzr.fast.test.unitils.service.EmployeeService;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringApplicationContext({"spring-ctx.xml"})
public class TestUnitils{

    @SpringBeanByType
    private EmployeeService employeeService;
    
    @Test
    public void testIoc(){
    	employeeService.save(new Employee("id1","name1"));
    	employeeService.save(new Employee("id2","name2"));    	
    	List employeeList = employeeService.findAll();
    	
    	assertThat((List<Object>)employeeList,hasItem(allOf(hasProperty("id",equalTo("id1")))));
    	
    }
    
}