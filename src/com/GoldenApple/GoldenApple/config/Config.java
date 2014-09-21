package com.GoldenApple.GoldenApple.config;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;

import com.GoldenApple.GoldenApple.Server;

public class Config {
	
	public static String path;
	
	public Config(){
		URL url = Config.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = null;
        try {
            filePath = URLDecoder.decode(url.getPath(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (filePath.endsWith(".jar")) {
            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
        }
        File file = new File(filePath);
        filePath = file.getAbsolutePath();
        path = filePath;
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
		boolean suc = false;
		File file = new File(path);
		if(!(file.isFile())){
			Server.getInstance().getLogger().error(new String());
		}
		
		return suc;
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
