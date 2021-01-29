package com.test02;

public class Elephant extends Animal{

	public Elephant() {
		System.out.println("코끼리");
	}
	
	@Override
	public void start() {
		System.out.println("도토가 쿵쿵 걷는다.");
	}
	
	@Override
	public void stop() {
		System.out.println("도토가 멈췄다.");
	}
}
