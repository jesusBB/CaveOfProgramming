package com.caveofprogramming.test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Logger {

	private ConsoleWriter consoleWriter;
	
	private FileWriter fileWriter;
	
//	@Resource(name="squirrel")
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	@Resource
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text){
		fileWriter.write(text);
	}
	
	public void writeConsole(String text){
		if(consoleWriter != null)
		consoleWriter.write(text);
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Initializing ..");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Destroying ...");
	}
	
}
