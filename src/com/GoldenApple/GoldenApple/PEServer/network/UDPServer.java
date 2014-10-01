package com.GoldenApple.GoldenApple.PEServer.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;

import com.GoldenApple.GoldenApple.Server;
import com.GoldenApple.GoldenApple.PEServer.network.packet.UNCONNECTED_PING_OPEN_CONNECTIONS;

public class UDPServer {
	
	private Server server;
	public UDPSocket sck;
	private boolean running = false;

	public UDPServer(Server server) throws SocketException, IOException{
		this.server = server;
		this.sck = new UDPSocket();
		running = true;
		while(running){
			DatagramPacket pck = sck.receive();
			readPacket(pck);
		}
	}
	
	private void readPacket(DatagramPacket pck) {
		byte pid = pck.getData()[0];
		switch(pid){
			//Handshake packets
			case RaknetInfo.UNCONNECTED_PING:
			case RaknetInfo.UNCONNECTED_PING_OPEN_CONNECTIONS:
				UNCONNECTED_PING_OPEN_CONNECTIONS packet = new UNCONNECTED_PING_OPEN_CONNECTIONS(pck, server);
				
			case RaknetInfo.OPEN_CONNECTION_REQUEST_1:
			case RaknetInfo.OPEN_CONNECTION_REQUEST_2:
			//Data packets
			default:
				if(pid <= RaknetInfo.DATA_PACKET_0 && pid >= RaknetInfo.DATA_PACKET_F){
					
				}else if(pid == RaknetInfo.ACK || pid == RaknetInfo.NACK){
					
				}else{
					
				}
		}
	}
	
	public void handleDatapack(byte[] data){
		
	}

	public void close(){
		running = false;
		sck.close();
	}
	
}
