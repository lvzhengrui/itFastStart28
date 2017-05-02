package org.lvzr.fast.test.powermock.complex;

import java.util.List;

public class EmployeeRepository {
	
	private EmployeeTableUtil tableUtil;

	public int count() {
		return new EmployeeTableUtil().count();
	}

	public List<Employee> findAll() {
		return EmployeeTableUtil.findAll();
	}

	public boolean insert(Employee employee) {
		try {
			tableUtil.insert(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean update(Employee employee) {
		try {
			EmployeeTableUtil.update(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(Employee employee) {
		return tableUtil.delete(employee);
	}

	private double bonus(Employee employee) {
		return employee.getSalary() * 0.1d;
	}

	public void setTableUtil(EmployeeTableUtil tableUtil) {
		this.tableUtil = tableUtil;
	}
}
