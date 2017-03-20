package com.caveofprogramming.test;

import org.springframework.stereotype.Component;

@Component("fileWriterrr")
public class FileWriter implements LogWriter {
	public void write(String text){
		System.out.println("Write to file: " + text);
	}
}
