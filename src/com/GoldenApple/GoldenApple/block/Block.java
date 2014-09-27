package com.GoldenApple.GoldenApple.block;

public abstract class Block implements PEBlock, PCBlock{
	
	private int id;
	private int meta;
	private int count;
	
	public abstract Object toPE();
	public abstract Object toPC();
	
	public Block(){
		this(0, 0, 1);
	}
	
	public Block(int id){
		this(id, 0, 0);
	}
	
	public Block(int id, int meta){
		this(id, meta, 1);
	}
	
	public Block(int id, int meta, int count){
		this.id = id;
		this.meta = meta;
		this.setCount(count);
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getID(){
		return this.id;
	}
	
	public int getMeta(){
		return this.meta;
	}
	
}
