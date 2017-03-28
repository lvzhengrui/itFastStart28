package org.lvzr.fast.vo;

import java.io.Serializable;

import org.lvzr.fast.util.Const;

public class MyVo implements Serializable{

	private static final long serialVersionUID = 3778882340192607038L;
	
	private String name = Const.NAME_VALUE;
	
	private String city = Const.CITY_VALUE;

	private static MyVo myVo;
	
	public static MyVo getInstance(){
		if(myVo==null){
			myVo = new MyVo();
		}
		return myVo;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "MyVo [name=" + name + ", city=" + city + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyVo other = (MyVo) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}