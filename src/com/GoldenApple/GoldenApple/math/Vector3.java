package com.GoldenApple.GoldenApple.math;

public class Vector3 extends Vector2{
	
	public int y;
	
	public Vector3(int x, int y, int z){
		super(x, z);
		this.y = y;
	}
	
	public void addY(int y){
		this.y += y;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
}
