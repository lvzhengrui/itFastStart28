package org.lvzr.fast.java.annotation;

public class Mouse {

	@MyAnno(isCanNull = true)
	private String name;
	
	@MyAnno(isCanNull = false, isCanZero = false)
	private int age;
	
	@MyAnno(isCanNull = false)
	private String address;
	
	@MyAnno(isCanZero = false)
	private double money;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
