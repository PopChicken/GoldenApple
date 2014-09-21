package com.GoldenApple.GoldenApple.exception;

public class FileReadException extends Exception{
	
	public FileReadException(String path){
		super("File can't read:" + path);
	}

}
