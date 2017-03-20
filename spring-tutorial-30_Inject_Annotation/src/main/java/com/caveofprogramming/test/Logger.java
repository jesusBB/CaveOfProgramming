package com.caveofprogramming.test;

import javax.inject.Inject;
import javax.inject.Named;

public class Logger {

	private ConsoleWriter consoleWriter;
	
	private FileWriter fileWriter;
	
	@Inject
	@Named(value="consoleWriter")
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	@Inject
	
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
	
	
}
