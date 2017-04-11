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
	
	
	@Pointcut(value="execution(void com.caveofprogramming.spring.aop.Camera.snap())")
	public void cameraSnap(){}
	
	@Before(value="cameraSnap()")
	public void aboutToTakeAPhoto(){
		System.out.println("About to take a photo ...");
	}
}
