package org.lvzr.fast.test.powermock.complex;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTableUtil {

	public int count() {
		return 0;
	}

	public static final List<Employee> findAll() {
		return new ArrayList<Employee>();
	}

	public void insert(Employee employee) throws Exception {
		if (existed(employee.getId())) {
			throw new Exception();
		}
		// insert employee
	}

	public static final void update(Employee employee) throws Exception {
		if (employee == null) {
			throw new Exception();
		}
	}

	public boolean delete(Employee employee) {
		if (existed(employee.getId())) {
			// delete employee
			return true;
		}
		return false;
	}

	private boolean existed(String id) {
		return false;
	}

}