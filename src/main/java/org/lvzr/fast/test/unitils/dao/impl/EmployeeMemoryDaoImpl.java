package org.lvzr.fast.test.unitils.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lvzr.fast.test.unitils.dao.EmployeeDao;
import org.lvzr.fast.test.unitils.model.Employee;
import org.springframework.stereotype.Repository;

@Repository("employeeMemoryDao")
public class EmployeeMemoryDaoImpl implements EmployeeDao{

	Map<String, Employee> memoryStoreMap = new HashMap<String, Employee>();

	public List<Employee> findAll(){
		List<Employee> resultList = new ArrayList<Employee>();
		for(Employee employee:memoryStoreMap.values()){
			resultList.add(employee);
		}
		return resultList;
	}
	
	public boolean save(Employee employee){
		memoryStoreMap.put(employee.getId(), employee);
		return true;
	}
	
	public boolean delete(String id){
		memoryStoreMap.remove(id);
		return true;
	}
	
	public Employee get(String id){
		return memoryStoreMap.get(id);
	}
	
}