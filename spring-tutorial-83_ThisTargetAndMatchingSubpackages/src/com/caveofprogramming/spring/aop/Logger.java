package com.caveofprogramming.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	
	
	// ..* allows to include any subpackage inside the last package. Without that, we just include classes of the last package
	@Pointcut(value="within(com.caveofprogramming.spring..*)")
	public void withinDemo(){}
	
	//Using target we specify a class and any instance that match with that class will throw the method. 
	//Wildcards are not allowed with target because we must specify the class
	@Pointcut("target(com.caveofprogramming.spring.aop.Camera)")
	public void targetDemo(){}
	
	//The difference of this and target is that this checks the proxy object instead of the class. So that means that you need to specify the implementation of the class instead of the class
	//In this case, if we set the value to Camera class won´t work, we need to specify one of its interfaces (like ICamera)
	@Pointcut("this(com.caveofprogramming.spring.aop.ICamera)")
	public void thisDemo(){}
	
	@Before("withinDemo()")
	public void withinDemoAdvice(){
		System.out.println("*************Before Demo***************");
	}
	
	@Before("targetDemo()")
	public void targetDemoAdvice(){
		System.out.println("*************Target Demo***************");
	}
	
	@Before("thisDemo()")
	public void thisDemoAdvice(){
		System.out.println("*************This Demo***************");
	}
	
	
}
