package com.GoldenApple.GoldenApple.PEServer.network.security;

import java.net.DatagramPacket;

import com.GoldenApple.GoldenApple.PEServer.network.Datapack.Datapack;

/**
 *
 * Sorry, for security reason, we'll write the security system in another program.
 * 
 */
public abstract class Main {
	
	public abstract boolean checkHandShakePacket(DatagramPacket pck);
	
	public abstract boolean checkDataPacket(Datapack pck);
	
	public abstract boolean checkPacket(DatagramPacket pck);
}
