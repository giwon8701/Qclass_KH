package com.j05;

public class Animal {
	
	private String kind;
	private int age;
	
	public Animal(String kind, int age) {
		this.kind = kind;
		this.age = age;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void bark(String bark) {
		System.out.println("울음소리 : " + bark);
	}

}
