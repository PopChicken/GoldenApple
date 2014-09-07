package com.GoldenApple.GoldenApple;

import java.util.Properties;

class Loader {
	
	public static String system;
	
	public Loader(){
		Properties properties = System.getProperties();
		system = properties.getProperty("os.name");
	}
    
	public static boolean startServer() {
		boolean start = true;
		
		return start;
	}

	public static void main(String args[]){
		System.out.println("GoldenApple Loading...");
		new Loader();
		startServer();
	}
	
}
