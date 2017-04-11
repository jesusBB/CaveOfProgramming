package com.caveofprogramming.spring.aop;

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
	
	
	@Pointcut(value="execution(* com.caveofprogramming.spring.aop.Camera.snap*(..))")//.. means with any arguments
	public void cameraSnap(){}
	
	@Pointcut(value="execution(* com.caveofprogramming.spring.aop.Camera.snap(String))")
	public void cameraSnapName(){}
	
	@Pointcut(value="execution(* com.caveofprogramming.spring.aop.*.*(..))")
	public void cameraRelatedAction(){}
	
	@Before(value="cameraSnap()")
	public void aboutToTakeAPhoto(){
		System.out.println("About to take a photo ...");
	}
	
	@Before(value="cameraSnapName()")
	public void aboutToTakeAPhotoWithName(){
		System.out.println("About to take a photo with Name...");
	}
	
	@Before(value="cameraRelatedAction()")
	public void aboutToDoCameraRelatedAction(){
		System.out.println("Doing something related to cameras...");
	}
}
