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
	
	/* This way to advise another method is not reusable but simpler
	 * 
	@Before(value="execution(void com.caveofprogramming.spring.aop.Camera.snap())")
	public void aboutToTakeAPhoto(){
		System.out.println("About to take a photo ...");
	}*/
	
	
	@Pointcut(value="execution(* com.caveofprogramming.spring.aop.Camera.snap())")//.. means with any arguments
	public void cameraSnap(){}
	
	
	@Before(value="cameraSnap()")
	public void beforeAdvice(){
		System.out.println("Before advice ...");
	}
	
	/*@After(value="cameraSnap()")
	public void afterAdvice(){
		System.out.println("After advices...");
	}
	
	@AfterReturning(value="cameraSnap()")
	public void afterReturningAdvice(){
		System.out.println("Everything is fine. No exceptions in the advised method so .. I'll be run!!...");
	}
	
	@AfterThrowing(value="cameraSnap()")
	public void afterThrowingAdvice(){
		System.out.println("A exception has been thrown in the advised method so .. I'll be run!!...");
	}
	
	@Around(value="cameraSnap()")
	public void aroundAdvice(ProceedingJoinPoint p){
		System.out.println("Around advice before...");
		
		try {
			p.proceed();
			System.out.println("Class:" + p.getClass());
			System.out.println("Kind:" + p.getKind());
			System.out.println("Target class: " + p.getTarget().getClass());
		} catch (Throwable e) {
			System.out.println("In around advice:" + e.getMessage());
		}
		
		System.out.println("Around advice after...");
	}*/
}
