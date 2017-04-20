package com.caveofprogramming.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	
	//With the PCD @Deprecated the methods who are in class annotated with @Deprecated will be run.
	//To set this value to annotations which are not java internal classes, we need to specify the whole path.
	/*//like (org.springframework.stereotype.Component)
	@Pointcut(value="within(@Deprecated com.caveofprogramming.spring..*)")
	public void somePointCut(){}
	
	
	
	@Before("somePointCut()")
	public void somePointCutDemo(){
		System.out.println("*************BEFORE DEMO***************");
	}*/
	
	
	//If we set the PDC target with the @ symbol before, we need to specify the annotation class that we´d like to match.
	//For example, in this case we´ll match the methods of all the class which are annotated with @Component
	/*@Pointcut(value="@target(org.springframework.stereotype.Component)")
	public void somePointCut(){}
	
	
	
	@Before("somePointCut()")
	public void somePointCutDemo(){
		System.out.println("*************BEFORE DEMO***************");
	}*/
	
	//This will target all the methods annotated as Deprecated
	/*@Pointcut(value="@annotation(Deprecated)")
	public void somePointCut(){}
	
	
	
	@Before("somePointCut()")
	public void somePointCutDemo(){
		System.out.println("*************BEFORE DEMO***************");
	}*/
	
	//This PCD can be a bit tricky and unexpected. What it does is that any method who has as an argument an object of a class
	//which is annotated with the specified class will match with the pointcut
	/*@Pointcut(value="@args(Deprecated)")
	public void somePointCut(){}
	
	
	
	@Before("somePointCut()")
	public void somePointCutDemo(){
		System.out.println("*************BEFORE DEMO***************");
	}*/
	
	@Pointcut(value="bean(camera)")
	public void somePointCut(){}
	
	
	
	@Before("somePointCut()")
	public void somePointCutDemo(){
		System.out.println("*************BEFORE DEMO***************");
	}
	
	
}
