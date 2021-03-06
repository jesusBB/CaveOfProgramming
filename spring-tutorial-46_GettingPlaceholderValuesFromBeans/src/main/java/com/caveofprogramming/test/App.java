package com.caveofprogramming.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/caveofprogramming/test/beans/beans.xml");
		
		OffersDAO offersDAO = (OffersDAO) context.getBean("offersDao");
		
		List<Offer> offers;
		try {
			
			Offer offer1 = new Offer("Dave", "dave@caveofprogramming.com", "Coding Java");
			Offer offer2 = new Offer("Karen", "karen@caveofprogramming.com", "Software testing");
				
			if(offersDAO.create(offer1)){
				System.out.println("Object created");
			}
			
			if(offersDAO.create(offer2)){
				System.out.println("Object created");
			}
			
			offers = offersDAO.getOffers();
			for(Offer offer : offers){
				System.out.println(offer);
			}
			
			Offer offer = offersDAO.getOffer(2);
			System.out.println(offer);
			
			System.out.println("Rows deleted: " + (offersDAO.delete(2) ? 1 : 0));
		} catch (CannotGetJdbcConnectionException ex){
			System.out.println("Cannot get database connection");
		}
		 catch (DataAccessException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}
		
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
