package org.lvzr.fast.test.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.lvzr.fast.test.powermock.complex.Employee;


public class testHamcrest {

	@Test
	public void testHamcrest() {
		// 比较50是否和50相等
		assertThat(50, Matchers.equalTo(50));
		// 50是否大于30并且小于60
		assertThat("错误", 50, greaterThan(30));
		assertThat("错误", 50, allOf(greaterThan(30), lessThan(60)));
		assertThat("错误", 50, anyOf(greaterThan(100), lessThan(60)));
		// 判断字符串是否以.txt结尾
		assertThat("错误", "abc.txt", endsWith(".txt"));
		
		//测试array
		String[] strArray = new String[]{"aa","bb","cc","dd"};
		assertThat(strArray, hasItemInArray("aa"));
		
		//测试List<String>
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("abb");
		assertThat(list, hasItem("aaa"));
		assertThat(list, allOf(hasItem("aaa"),hasItem("abb")));
		assertThat(list, anyOf(hasItem("aaa"),hasItem("ccc")));
		assertThat(list, everyItem(startsWith("a")));
		assertThat(list, not(everyItem(startsWith("b"))));
		
		//测试Map<String,String>
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		assertThat(map , hasKey("key1"));
		assertThat(map , hasValue("value1"));
		assertThat(map , hasEntry("key1", "value1"));
		
		//测试List<Pojo>
		Employee employee1 = new Employee("id1","name1",100);
		Employee employee2 = new Employee("id2","name2", 200);
		List employeeList = new ArrayList<Employee>();
		employeeList.add(employee1);
		employeeList.add(employee2);
		
		assertThat((List<Object>)employeeList, hasItem(allOf(
				hasProperty("id")
			   ,hasProperty("salary")
			   )));
		assertThat((List<Object>)employeeList, hasItem(anyOf(
				hasProperty("id")
			   ,hasProperty("salary")
			   ,hasProperty("demo")
			   )));
		assertThat((List<Object>)employeeList, hasItem(anyOf(
				hasProperty("id", equalTo("id1"))
				,hasProperty("name", equalTo("name1"))
			   )));
		assertThat((List<Object>)employeeList, hasItem(allOf(
				hasProperty("id", equalTo("id1"))
				,hasProperty("name", equalTo("name1"))
			   )));
		
		assertThat((List<Object>)employeeList, hasItem(anyOf(
				hasProperty("id", equalTo("id1"))
				,hasProperty("name", equalTo("name2"))
			   )));
		assertThat((List<Object>)employeeList, not(hasItem(allOf(
				hasProperty("id", equalTo("id1"))
				,hasProperty("name", equalTo("name2")))
			   )));
		
	}
	
}
