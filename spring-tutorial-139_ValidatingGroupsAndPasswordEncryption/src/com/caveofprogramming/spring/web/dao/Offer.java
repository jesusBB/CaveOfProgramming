package com.caveofprogramming.spring.web.dao;

import javax.validation.constraints.Size;

public class Offer {
	private int id;
	
//	@Size(min=5, max=100)
//	private String name;
//	
//	@NotNull
//	@ValidEmail(min=6)
//	private String email;
	
	@Size(min=5, max=255)
	private String text;
	
	private User user;
	
	public Offer() {
		this.user = new User();
	}

	public Offer(String text, User user) {
		this.user = user;
		this.text = text;
	}
	
	

	public Offer(int id, User user,  String text) {
		super();
		this.id = id;
		this.user = user;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", text=" + text + ", user=" + user + "]";
	}

	public String getUsername(){
		return this.user.getUsername();
	}

}
