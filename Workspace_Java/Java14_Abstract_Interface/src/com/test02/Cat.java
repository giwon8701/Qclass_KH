package com.test02;

public class Cat extends Animal {

	public Cat() {
		System.out.println("고양이");
	}
	
	@Override
	public void start() {
		System.out.println("고양이가 사뿐사뿐 걷는다.");
	}
	
	@Override
	public void stop() {
		System.out.println("고양이가 멈췄다.");
	}

}
