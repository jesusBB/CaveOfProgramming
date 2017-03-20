package com.caveofprogramming.test;

import java.util.List;

public class FruitBasket {
	private String name;
	private List<String> fruits;
	
	public FruitBasket() {
		super();
	}

	public FruitBasket(String name, List<String> fruits) {
		super();
		this.name = name;
		this.fruits = fruits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFruits() {
		return fruits;
	}

	public void setFruits(List<String> fruits) {
		this.fruits = fruits;
	}

	@Override
	public String toString() {
		return "FruitBasket [name=" + name + ", fruits=" + fruits + "]";
	}
	
	
	
}
