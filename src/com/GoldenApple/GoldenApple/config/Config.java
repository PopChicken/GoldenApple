package com.GoldenApple.GoldenApple.config;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;

import com.GoldenApple.GoldenApple.Server;

public class Config {
	
	public static String path;
	
	public Config(){
        path = Server.getInstance().getServerConfigPath();
	}
	
	public Config(String fileName){
		new Config();
		path = new String(path + "/" + fileName);
		boolean suc = load();
		if(suc == false){
			Server.getInstance().getLogger().error(new String());
		}
	}
	
	private boolean load() {
//		boolean suc = false;
//		File file = new File(path);
//		if(!(file.isFile())){
//			Server.getInstance().getLogger().error(new String());
//		}
//		
//		return suc;
		// TODO
	}
	
	public void reload(){
		
	}

	public String getPath(){
		return path;
	}
	
	protected String get(String key){
		String value = null;
		return value;
	}
	
	protected void set(String key, String value){
		
	}
	
}
