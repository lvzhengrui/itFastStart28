package org.lvzr.fast.java.spring.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSimpleAspect {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"org/lvzr/fast/spring/aop/aspectj/spring-ctx.xml");
		PersonService personService = appContext.getBean(PersonService.class);
		String personName = "Jerry";
		personService.addPerson(personName);
		personService.deletePerson(personName);
		personService.editPerson(personName);
		((ClassPathXmlApplicationContext) appContext).close();
	}

}