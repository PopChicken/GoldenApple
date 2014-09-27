package com.GoldenApple.GoldenApple.util;

public class Logger {
	
	public void info(String str){
		log(new String("[Info]" + str));
	}
	
	public void emergence(String str){
		log(new String("[Emergence]" + str));
	}
	
	public void error(String str){
		log(new String("[Error]" + str));
	}
	
	public void debug(String str){
		log(new String("[Debug]" + str));
	}
	
	public void warning(String str){
		log(new String("[Warning]" + str));
	}
	
	public void log(String str){
		System.out.print(str);
	}

	public void addHook(Object className) {
		// TODO Auto-generated method stub
		
	}
}
