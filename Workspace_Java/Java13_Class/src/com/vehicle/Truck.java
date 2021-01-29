package com.vehicle;

public class Truck extends Car {
	
	public Truck() {
		System.out.println("truck 생성");
	}
	public Truck(String color) {
		System.out.println("출력 : " + color + " truck 생성");
	}
	
	public void accelPedal() {
		System.out.println("속도가 15 올라갑니다.");
		setSpeed(getSpeed()+15);
	}
	
	public void breakPedal() {
		setSpeed(getSpeed()-15);
		if (getSpeed() > 0) {
			System.out.println("속도가 15 줄어듭니다.");
		} else {
			System.out.println("멈췄습니다.");
			setSpeed(0);
		}
	}
}
