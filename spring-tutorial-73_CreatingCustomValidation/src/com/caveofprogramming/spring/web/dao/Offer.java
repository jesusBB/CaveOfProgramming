package com.caveofprogramming.spring.web.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.caveofprogramming.spring.web.validations.ValidEmail;

public class Offer {
	
	private int id;
	
	//Localize the error message?challenge!!
	@Size(min=5, max=100, message="Name must have a different size (between 5 and 100)")
	private String name;
	
	@NotNull
//	@Pattern(regexp="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message="Email address invalid")
	@ValidEmail(min = 6, message="Este email es un mojon")
	private String email;
	
	@Size(min=20, max=255, message="Text must have a different size (between 20 and 255)")
	private String text;
	
	public Offer(int id, String name, String email, String text) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}
		
	public Offer(String name, String email, String text) {
		super();
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public Offer() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}
	
	
	
}
