package com.caveofprogramming.test;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

@Component
public class Logger {

	private ConsoleWriter consoleWriter;
	
	private FileWriter fileWriter;
	
	@Inject	
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	@Inject
	@Named(value="fileWriterrr") //in the FileWriter.java the name of the @Component has to macht with this @Named anotation
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
