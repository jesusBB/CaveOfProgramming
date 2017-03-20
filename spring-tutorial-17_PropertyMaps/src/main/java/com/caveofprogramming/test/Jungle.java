package com.caveofprogramming.test;

import java.util.HashMap;
import java.util.Map;

public class Jungle {
	private Map<String, String> foods = new HashMap<String, String>();

	
	
	public Map<String, String> getFoods() {
		return foods;
	}



	public void setFoods(Map<String, String> foods) {
		this.foods = foods;
	}



	@Override
	public String toString() {
		return "Jungle [foods=" + foods + "]";
	}
	
	
		
	
}
