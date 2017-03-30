package com.caveofprogramming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/caveofprogramming/test/beans/beans.xml");
		
		OffersDAO offersDAO = (OffersDAO) context.getBean("offersDao");
		for(Offer offer : offersDAO.getOffers()){
			System.out.println(offer);
		}
		
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
