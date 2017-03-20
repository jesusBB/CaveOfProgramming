package com.caveofprogramming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	
	public static void main(String[] args) {
		
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/caveofprogramming/test/beans/beans.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/caveofprogramming/test/beans/beans.xml");
		
		Person person = (Person) context.getBean("person");
		person.speak();

		Address address = (Address) context.getBean("address");
		System.out.println(address);
		
		System.out.println(person);
		
		((ClassPathXmlApplicationContext)context).close();

	}

}
