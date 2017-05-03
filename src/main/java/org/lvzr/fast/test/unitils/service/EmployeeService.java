package org.lvzr.fast.test.unitils.service;

import java.util.List;

import org.lvzr.fast.test.unitils.dao.EmployeeDao;
import org.lvzr.fast.test.unitils.model.Employee;

public interface EmployeeService{

	public void setEmployeeDao(EmployeeDao employeeDao);
	
	public List<Employee> findAll();
	
	public boolean save(Employee employee);
	
	public boolean delete(String id);
	
	public Employee get(String id);
 
}