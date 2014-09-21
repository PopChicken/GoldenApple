package com.GoldenApple.GoldenApple.PEServer.network.protocol;

public abstract class Packet {
	
	public static byte ID = -1;
	
	protected int offset = 0;
	public byte buffer;
	public int sendTime;
	
//	protected Object get(Object lenth){
//		if((int)lenth < 10){
//			offset = buffer - 1;
//			return "";
//		}else if((boolean)lenth == true){
//		}
//		return null;
//	}
}
