package com.caveofprogramming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/caveofprogramming/test/beans/beans.xml");
		
		FruitBasket basket = (FruitBasket) context.getBean("basket");
		
		System.out.println(basket);
		
//		Address address2 = (Address) context.getBean("address2");
//		System.out.println(address2);
		
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
