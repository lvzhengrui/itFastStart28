package org.lvzr.fast.test.unitils.service.impl;

import java.util.List;

import org.lvzr.fast.test.powermock.complex.Employee;
import org.lvzr.fast.test.unitils.dao.EmployeeDao;
import org.lvzr.fast.test.unitils.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	
	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> findAll(){
		return employeeDao.findAll();
	}
	
	public boolean save(Employee employee){
		return employeeDao.save(employee);
	}
	
	public boolean delete(String id){
		return employeeDao.delete(id);
	}
	
	public Employee get(String id){
		return employeeDao.get(id);
	}
 
}