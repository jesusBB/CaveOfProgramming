package com.caveofprogramming.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	//Using @DeclareParent in the the aspect class (MachineAspect.java) we can auto-implement an interface to the classes we want
	//to add that functionality to some existing classes. In this case we have Blender and Fun classes, then we create an interface called
	//IMachine and we want them to implement this interface. So we can create a class to implement that interface (Machine.java) and then
	//with @DeclareParent we specify that this implementation class will be used for all the classes inside our package (com.caveofprogramming.spring.aop).
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/caveofprogramming/spring/aop/beans.xml");
		
		
		IBlender blender = (IBlender) context.getBean("blender");
		((IMachine)blender).start();
		blender.blend();
		
		
		IFan fan = (IFan) context.getBean("fan");
		((IMachine)fan).start();
		fan.activate(5);
		
		context.close();

	}

}
