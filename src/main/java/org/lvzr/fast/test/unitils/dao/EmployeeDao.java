package org.lvzr.fast.test.unitils.dao;

import java.util.List;

import org.lvzr.fast.test.unitils.model.Employee;

public interface EmployeeDao{

	public List<Employee> findAll();
	
	public boolean save(Employee employee);
	
	public boolean delete(String id);
	
	public Employee get(String id);
}