package com.GoldenApple.GoldenApple;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;

import com.GoldenApple.GoldenApple.PEServer.network.UDPSocket;
import com.GoldenApple.GoldenApple.config.Config;
import com.GoldenApple.GoldenApple.util.Logger;

public class Server {
	
	private static Server instance;
	private static Loader loader;
	private static Logger logger;
	private String serverConfigPath;
	private UDPSocket socket;
	public boolean emergencyError = false;
	
	public Server(Loader loader, Logger logger, UDPSocket socket){
		instance = this;
		this.loader = loader;
		this.logger = logger;
		this.socket = socket;
		this.loadServerConfig();
	}
	
	private void loadServerConfig() {
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
        serverConfigPath = filePath;
	}

	public static Server getInstance(){
		return instance;
	}
	
	public Logger getLogger(){
		return logger;
	}

	public int getPort() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getServerConfigPath(){
		return this.serverConfigPath;
	}

	public Object getIP() {
		// TODO Auto-generated method stub
		return null;
	}

	public void shutdown() {
		socket.close();
		try{
		    wait(3);
		}catch(InterruptedException e){
			System.exit(1);
		}
		System.exit(0);
	}

	public void emergencyshutdown() {
		socket.close();
		System.exit(0);
	}

	
}
