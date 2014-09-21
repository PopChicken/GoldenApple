package com.GoldenApple.GoldenApple.config;

import com.GoldenApple.GoldenApple.Server;

public class Language extends Config{
	
	public String lang = "English";
	
	public Language(){
		boolean suc = load();
		if(!suc){
			Server.getInstance().getLogger().error(new String());
		}
	}
	
	public Language(String lang){
		this.lang = lang;
	}
	
	private boolean load(){
		return false;
	}
	
}
