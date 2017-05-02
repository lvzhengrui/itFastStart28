package org.lvzr.fast.test.powermock.complex;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * powermock测试
 * http://breezylee.iteye.com/blog/2088437
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeTableUtil.class)
public class EmployeeRepositoryTest{
	
   private EmployeeRepository repository;
   
   @Before
   public void init() throws Exception {
	   repository = new EmployeeRepository();
   }


   /**
    * mock静态方法
    */
   @Test
   public void should_mock_static_method() {
       List<Employee> employee = new ArrayList<Employee>();
       employee.add(new Employee("1"));
       employee.add(new Employee("2"));
       
       PowerMockito.mockStatic(EmployeeTableUtil.class);
       PowerMockito.when(EmployeeTableUtil.findAll()).thenReturn(employee);
       
       List<Employee> employees = repository.findAll();
       Assert.assertEquals(employees.size(), 2);
       Assert.assertEquals(employees.get(0).getId(), "1");
       Assert.assertEquals(employees.get(1).getId(), "2");
       PowerMockito.verifyStatic();
   }
   
   /**
    * mock Exception
    */
   @Test
   public void should_mock_exception_for_command_method_in_mock_object() {
       Employee employee = new Employee("1");
       PowerMockito.mockStatic(EmployeeTableUtil.class);
       PowerMockito.doThrow(new Exception()).when(EmployeeTableUtil.class);
       try{
    	   EmployeeTableUtil.update(employee);
       }catch(Exception e){
    	   e.printStackTrace();
       }
       Assert.assertEquals(repository.update(employee), false);
   }
   
   /**
    * mock私有方法
    * @throws Exception
    */
   @Test
   public void should_mock_private_method() throws Exception {
       Employee employee = new Employee("1");
       EmployeeTableUtil util = PowerMockito.spy(new EmployeeTableUtil());
       PowerMockito.when(util,"existed", Mockito.anyString()).thenReturn(true);
       repository.setTableUtil(util);
       Assert.assertEquals(repository.insert(employee), false);
       Assert.assertEquals(repository.delete(employee), true);
   }
   
   /**
    * 测试私有方法
    * @throws Exception
    */
   @Test
   public void should_test_private_method() throws Exception {
       Employee employee = new Employee("1");
       employee.setSalary(8000);
       double result = Whitebox.<Double>invokeMethod(repository, "bonus", employee);
       Assert.assertEquals(result, 800, 1);
   }
   
   
   
	    
	
}