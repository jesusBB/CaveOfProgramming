package com.caveofprogramming.spring.aop;

import org.springframework.stereotype.Component;

//Advice
@Component("camera")
public class Camera implements PhotoSnapper, Machine, ICamera {
	
	
	public Camera() {
		System.out.println("Hello from Camera constructor");
	}

	/* (non-Javadoc)
	 * @see com.caveofprogramming.spring.aop.ICamera#snap()
	 */
	@Override
	public void snap() throws Exception{
		System.out.println("SNAP!");
		
		throw new Exception("bye bye");
	}
	
	/* (non-Javadoc)
	 * @see com.caveofprogramming.spring.aop.ICamera#snap(int)
	 */
	@Override
	public void snap(int exposure){
		System.out.println("SNAP! with exposue: " + exposure);
	}
	
	/* (non-Javadoc)
	 * @see com.caveofprogramming.spring.aop.ICamera#snap(java.lang.String)
	 */
	@Override
	public String snap(String name){
		System.out.println("SNAP! with name: " + name);
		
		return name;
	}
	
	/* (non-Javadoc)
	 * @see com.caveofprogramming.spring.aop.ICamera#snapNightime()
	 */
	@Override
	public void snapNightime(){
		System.out.println("SNAP! Nigth mode");
	}
}
