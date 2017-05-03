package org.lvzr.fast.test.unitils.model;

import javax.persistence.Column;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 create table fs_employee(
   id varchar(32),
   name varchar(32),
   salary double,
   primary key (id)
 );
 */
@Entity
@Table(name="FS_EMPLOYEE")
public class Employee{
	
	@Id 
	@Column(name="id")
	@GeneratedValue(generator="Id")
	@GenericGenerator(name="Id", strategy="uuid")
	private String id;

	@Column(name="NAME")
	private String name;
	
	@Column(name="SALARY")
	private double salary;
	
	public Employee(String id){
		this.id = id;
	}

	public Employee(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Employee(String id, String name,double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}