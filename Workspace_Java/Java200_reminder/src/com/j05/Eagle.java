package com.j05;

public class Eagle extends Animal {

	public Eagle(String kind, int age) {
		super(kind, age);
	}
	
	@Override
	public void bark(String bark) {
		System.out.print("독수리의 : ");
		super.bark(bark);
	}
}