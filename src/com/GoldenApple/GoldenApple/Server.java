package com.GoldenApple.GoldenApple;

import com.GoldenApple.GoldenApple.util.Logger;

public class Server {
	
	private static Server instance;
	private static Loader loader;
	private static Logger logger;
	
	public Server(Loader loader, Logger logger){
		instance = this;
		this.loader = loader;
		this.logger = logger;
	}
	
	public static Server getInstance(){
		return instance;
	}
	
	public Logger getLogger(){
		return logger;
	}
	
}
