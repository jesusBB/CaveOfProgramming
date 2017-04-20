package com.caveofprogramming.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
/*	@Pointcut(value="target(com.caveofprogramming.spring.aop.Camera)")
	public void somePointCut(){}
	
	
	
	@Before("somePointCut()")
	//Using JoinPoint we can get the values of the arguments of the target method.
	//This method is quite flexible but you may need to cast to the possible classes you expect
	public void somePointCutDemo(JoinPoint jp){
		System.out.println("*************BEFORE DEMO***************");
		
		for(Object obj :jp.getArgs()){
			System.out.println("ARG:" + obj);
		}
	}*/
	
	//This way to get arguments for target method is less flexible but it can be a good option if you really know the type
	//of data you are working with.
	@Pointcut("args(exposure, aperture)")
	public void somePointCut(int exposure, double aperture){}
	
	
	@Before("somePointCut(exposure, aperture)")
	public void somePointCutDemo(JoinPoint jp,int exposure, double aperture){
		System.out.println("*************BEFORE DEMO***************");
		
		System.out.printf("Exposure %d, aperture %.2f\n", exposure, aperture);
	}
	
}
