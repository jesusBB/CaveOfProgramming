package com.caveofprogramming.spring.aop;

import org.springframework.stereotype.Component;

//Advice
@Component
public class Camera {
	public void snap(){
		System.out.println("SNAP!");
	}
}
