package com.caveofprogramming.spring.aop;

public interface ICamera {

	void snap() throws Exception;

	void snap(int exposure);

	String snap(String name);

	void snapNightime();

	void snapCar(Car car);


}