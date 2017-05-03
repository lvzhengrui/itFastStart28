package org.lvzr.fast.test.unitils;

import java.util.List;

import org.junit.Test;
import org.lvzr.fast.test.powermock.complex.Employee;
import org.lvzr.fast.test.unitils.dao.EmployeeDao;
import org.lvzr.fast.test.unitils.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;
import org.unitils.spring.annotation.SpringBeanByType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringApplicationContext({"spring-ctx.xml"})
public class TestUnitils extends UnitilsJUnit4{ //±ØÐë¼Ì³ÐUnitilsJUnit4

    @SpringBeanByType
	private EmployeeDao employeeDao;
	
    @SpringBeanByType 
    private EmployeeService employeeService;

    @SpringApplicationContext
    private ApplicationContext applicationContext;  
    
    @Test
    public void testIoc(){
    	employeeDao.save(new Employee("id1","name1"));
    	
    	employeeService.save(new Employee("id2","name2"));
    	employeeService.save(new Employee("id3","name3"));    	
    	List employeeList = employeeService.findAll();
    	
    	assertThat((List<Object>)employeeList, hasSize(3));
    	assertThat((List<Object>)employeeList,hasItem(allOf(hasProperty("id",equalTo("id1")))));
    	
    }
    
}