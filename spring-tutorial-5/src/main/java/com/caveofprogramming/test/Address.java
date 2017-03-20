package com.caveofprogramming.test;

public class Address {
	
	private String street;
	private String postcode;
	
	public Address(String street, String postcode) {
		super();
		this.street = street;
		this.postcode = postcode;
	}

//	public Address() {
//		super();
//	}



	@Override
	public String toString() {
		return "Address [street=" + street + ", postcode=" + postcode + "]";
	}
	
	
	
}
