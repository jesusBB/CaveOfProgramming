package com.caveofprogramming.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Logger {

	private ConsoleWriter consoleWriter;
	
	private FileWriter fileWriter;
	
	/*public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter){
		this.consoleWriter = consoleWriter;
		this.fileWriter = fileWriter;
	}*/
	
	@Autowired
	@Qualifier("toconsole")
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	@Autowired
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
