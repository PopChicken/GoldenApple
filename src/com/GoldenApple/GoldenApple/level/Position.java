package com.GoldenApple.GoldenApple.level;

import com.GoldenApple.GoldenApple.math.Vector3;

public class Position extends Vector3{
	
	public Level level;
	
	public Position(int x, int y, int z, Level level){
		super(x, y, z);
		this.level = level;
	}
	
}
