package com.caveofprogramming.spring.aop;

import org.springframework.stereotype.Component;

//Advice
@Component
public class Camera {
	public void snap() throws Exception{
		System.out.println("SNAP!");
		
		throw new Exception("bye bye");
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
