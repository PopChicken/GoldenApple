package com.GoldenApple.GoldenApple.event.player;

import com.GoldenApple.GoldenApple.Player;

public abstract class PlayerEvent {  
	
	public Player player;

	public PlayerEvent(Player player){
		this.player = player;
	}
	
	public Player getPlayer(){
		return player;
	}
	
}
