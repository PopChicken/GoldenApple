package com.GoldenApple.GoldenApple.PEServer.network;

import java.io.IOException;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Arrays;

import com.GoldenApple.GoldenApple.Server;

public class UDPSocket {
	
	private Server server;
	private int port;
	private String ip;
	private DatagramSocket socket;
	public static boolean connected;
	final int BS = 65535;

	public UDPSocket(){
		this(Server.getInstance());
	}
	
	public UDPSocket(Server server){
		this.server = server;
		this.port = server.getPort();
		this.ip = (String) server.getIP();
		try{
		    start();
		}catch(SocketException se) {
			server.getLogger().error("Could not create socket on " + ip + ":" + port +".\nServer will exit in 5 seconds.");
			server.shutdown();
		}
	}

	private void start(/*boolean ready*/) throws SocketException {
		if(!connected){
			socket = new DatagramSocket();
			boolean ready = true;
			socket.setBroadcast(ready);
			socket.setSendBufferSize(BS);
			socket.setReceiveBufferSize(BS);
			try{
				socket.bind(new InetSocketAddress(ip, port));
			}catch(BindException e){
				server.getLogger().fatal("Could not create socket on " + ip + ":" + port +".\nServer will exit NOW.");
				server.emergencyshutdown();
			}
		}
	}
	
	public int sendTo(byte[] buffer, String ip, int port) throws IOException{
		socket.send(new DatagramPacket(buffer, buffer.length, new InetSocketAddress(ip, port)));
		return buffer.length;
	}
	public int sendTo(byte[] buffer, InetSocketAddress address) throws IOException{
			socket.send(new DatagramPacket(buffer, buffer.length, address));
			return buffer.length;
	}
	public int send(DatagramPacket pck) throws IOException{
		socket.send(pck);
		return pck.getData().length;
	}

	public DatagramPacket receive() throws SocketException, IOException{
		byte buffer[] = new byte[1536];
		DatagramPacket rcvpck = new DatagramPacket(buffer, 1536);
		socket.receive(rcvpck);
		rcvpck.setData(Arrays.copyOf(buffer, rcvpck.getLength()));
		return rcvpck;
	}
	
	public DatagramSocket getSocket(){
		return socket;
	}

	public void close() {
		socket.disconnect();
		socket.close();
	}
	
}
