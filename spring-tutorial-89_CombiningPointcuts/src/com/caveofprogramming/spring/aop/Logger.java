package com.caveofprogramming.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	@Pointcut("args(exposure, aperture)")
	public void somePointCut(int exposure, double aperture){}


	@Pointcut("target(com.caveofprogramming.spring.aop.Camera)")	
	public void targetCamera(){}
	
	
	//We can combine pointcuts adding logical operators like && or ||
	@Before("targetCamera() && somePointCut(exposure, aperture)")
	public void somePointCutDemo(JoinPoint jp,int exposure, double aperture){
		System.out.println("*************BEFORE DEMO***************");
		
		System.out.printf("Exposure %d, aperture %.2f\n", exposure, aperture);
	}
	
	//Another way to combine pointcuts is writting the expression straightway in the advice annotation.
	//This case we are saying run all the methods in the Camera class that is not deprecated
	@After("within(com.caveofprogramming.spring.aop.*) && !@annotation(Deprecated)")
	public void someAfterAdvice(){
		System.out.println("After advice running!!!!");
	}
	
}
