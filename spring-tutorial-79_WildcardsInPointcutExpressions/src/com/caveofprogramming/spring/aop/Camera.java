package com.caveofprogramming.spring.aop;

import org.springframework.stereotype.Component;

//Advice
@Component
public class Camera {
	public void snap(){
		System.out.println("SNAP!");
	}
	
	public void snap(int exposure){
		System.out.println("SNAP! with exposue: " + exposure);
	}
	
	public String snap(String name){
		System.out.println("SNAP! with name: " + name);
		
		return name;
	}
	
	public void snapNightime(){
		System.out.println("SNAP! Nigth mode");
	}
}
