package com.caveofprogramming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/caveofprogramming/test/beans/beans.xml");
		
		Person person1 = (Person) context.getBean("person");
		

		person1.setTaxId(666);
		System.out.println(person1);
		
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
