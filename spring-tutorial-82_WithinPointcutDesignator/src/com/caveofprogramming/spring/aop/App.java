package com.caveofprogramming.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/caveofprogramming/spring/aop/beans.xml");
		
		Object obj =  context.getBean("camera");
		
		ICamera camera = (ICamera) context.getBean("camera");
		
		try {
			camera.snap();
			camera.snap(500);
			camera.snapNightime();
			
			Car car = (Car) context.getBean("car");
			car.start();
		} catch (Exception e) {
//			System.out.println("Caught exception:" + e.getMessage());
		}
		
		
		context.close();

	}

}
