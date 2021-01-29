package com.kh.test.duck.model.vo;

public abstract class Duck {

	private String name;
	private String kinds;
	
	// constructor
	protected Duck() {}
	protected Duck(String name, String kinds) {
		this.name = name;
		this.kinds = kinds;
	}
	
	// + setter/getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	
	//  + toString() : String
	@Override
	public String toString() {
		return "저는 " + kinds + "이고, 이름은 " + name + "입니다.";
	}
	
	// +quack() : void (abstract)
	public abstract void quack();
}
