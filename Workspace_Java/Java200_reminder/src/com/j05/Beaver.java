package com.j05;

public class Beaver extends Animal {
	
	public Beaver(String kind, int age) {
		super(kind, age);
	}

	@Override
	public void bark(String bark) {
		System.out.print("비버의 ");
		super.bark(bark);
	}	
}
