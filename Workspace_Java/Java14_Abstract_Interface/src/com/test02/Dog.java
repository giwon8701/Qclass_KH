package com.test02;

public class Dog extends Animal {

	public Dog() {
		System.out.println("멍멍이");
	}
	
	@Override
	public void start() {
		System.out.println("멍멍이가 촐랑촐랑 걷는다.");
	}

	@Override
	public void stop() {
		System.out.println("멍멍이가 멈췄다.");
	}

}
