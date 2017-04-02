package com.caveofprogramming.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/caveofprogramming/test/beans/beans.xml");
		
		OffersDAO offersDAO = (OffersDAO) context.getBean("offersDao");
		
		List<Offer> offers = new ArrayList<Offer>();
		try {
			
//			Offer offer2 = new Offer(7, "Claire", "Claire@caveofprogramming.com", "Web design to fit any budget");
//			offers.add(offer2);
			offers.add(new Offer(6,"Jesuli", "Jesuli@caveofprogramming.com", "Cash for Software"));
			offers.add(new Offer(2, "Paco", "Paco@caveofprogramming.com", "Elegant web design"));
			int[] rivals = offersDAO.create(offers);
			
			for(int value : rivals){
				System.out.println("updated " + value + " rows.");
			}
			
//			Offer offer = offersDAO.getOffer(2);
//			System.out.println(offer);
			
//			System.out.println("Rows deleted: " + (offersDAO.delete(2) ? 1 : 0));
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
