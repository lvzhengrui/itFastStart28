package org.lvzr.fast.test.unitils;

import java.util.List;

import org.junit.Test;
import org.lvzr.fast.test.unitils.dao.EmployeeDao;
import org.lvzr.fast.test.unitils.model.Employee;
import org.lvzr.fast.test.unitils.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;
import org.unitils.spring.annotation.SpringBeanByName;
import org.unitils.spring.annotation.SpringBeanByType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringApplicationContext({"org/lvzr/fast/test/unitils/spring-ctx.xml"})
public class TestUnitilsSpring extends UnitilsJUnit4{ //±ØÐë¼Ì³ÐUnitilsJUnit4

    //@SpringApplicationContext({"spring-ctx.xml"})
    @SpringApplicationContext
    private ApplicationContext applicationContext;  
    
    @SpringBeanByName
	private EmployeeDao employeeMemoryDao;
	
    //SpringBean("employeeService");
    @SpringBeanByType 
    private EmployeeService employeeService;
 
	/**
     * ÕûºÏSpring
     * @return
     */
    @Test
    public void testSpring(){
    	employeeMemoryDao.save(new Employee("id1","name1"));
    	
    	employeeService.save(new Employee("id2","name2"));
    	employeeService.save(new Employee("id3","name3"));    	
    	List employeeList = employeeService.findAll();
    	
    	assertThat((List<Object>)employeeList, hasSize(3));
    	assertThat((List<Object>)employeeList,hasItem(allOf(hasProperty("id",equalTo("id1")))));    	
    }
    
}