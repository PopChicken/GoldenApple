package com.GoldenApple.GoldenApple.exception;

import com.GoldenApple.GoldenApple.Server;

public class ConfigException extends Exception{
	
	public ConfigException(String filePath){
		Server.getInstance().getLogger().log("Can't read config:" + filePath);
	}

}
