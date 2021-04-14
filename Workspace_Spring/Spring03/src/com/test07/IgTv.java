package com.test07;

public class IgTv implements TV {

	IgTv() {
		System.out.println("ig tv created");
	}
	
	@Override
	public void powerOn() {
		System.out.println("lgTv tv on");
	}

	@Override
	public void powerOff() {
		System.out.println("lgTv tv off");
	}

	@Override
	public void volumeUp() {
		System.out.println("lgTv tv volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("lgTv tv volume down");
	}

}
