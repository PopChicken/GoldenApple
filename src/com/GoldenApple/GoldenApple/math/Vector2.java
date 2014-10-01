package com.GoldenApple.GoldenApple.math;

public class Vector2 {
	
	public int x, z;
	
	public Vector2(int x, int z) {
		this.x = x;
		this.z = z;
	}
	
	public synchronized void addX(int x){
		this.x += x;
	}
	
	public synchronized void addZ(int z){
		this.z += z;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getZ(){
		return this.z;
	}

	public synchronized void setX(int x){
		this.x = x;
	}
	
	public synchronized void setZ(int z){
		this.z = z;
	}
	
}
