package com.caveofprogramming.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//THE BEST WAY TO LEARN THE SPEL OPERATOR IS LOOKING AT THE SPRING DOCUMENTATION

@Component
public class Robot {
	
	private String id = "Default robot";
	private String speech = "hello";
	
	public void speak(){
		System.out.println(id + ": " + speech);
	}
	
	@Autowired
	public void setId(@Value("#{randomText.getText()?.length()}")String id) {
		this.id = id;
	}
	
	@Autowired
//	public void setSpeech(@Value("#{new java.util.Date().toString()}")String speech) {
//		this.speech = speech;
//	}
	//SpEL introduced T() operator which gives you access to static methods and constants on a given class.
	public void setSpeech(@Value("#{T(Math).PI le 3 ? 'yes' : 'no'} ")String speech) {
		this.speech = speech;
	}
	
	
}
