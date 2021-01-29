package com.kh.test.duck.model.vo;

public class Mallard extends Duck {

	private String location;
	private String color;
	
	public Mallard() {}
	public Mallard(String name, String kinds, String location, String color) {
		setName(name);
		setKinds(kinds);
		this.location = location;
		this.color = color;
	}
	
	// + setter/getter
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation(String location) {
		return location;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor(String color) {
		return color;
	}
	
	public void quack() {
		System.out.println(toString() + " 주 서식지는 " + location + "이며, 색상은 " + color + "입니다.");
	}
}
