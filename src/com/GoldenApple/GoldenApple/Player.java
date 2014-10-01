package com.GoldenApple.GoldenApple;

import com.GoldenApple.GoldenApple.PEServer.network.Datapack.Datapack;
import com.GoldenApple.GoldenApple.entity.Human;

public class Player extends Human{
	
	private String name;
	private String displayName;
	private String ip;
	private int port;
	
	public class PacketHandler {
		
		public void handle(Datapack pck){
			
		}
		
	}
	
	public String getDisplayName(){
		return displayName;
	}
	
	public String getName(){
		return name;
	}
	
	public String getIP(){
		return ip;
	}
	
	public int getPort(){
		return port;
	}
	
}
