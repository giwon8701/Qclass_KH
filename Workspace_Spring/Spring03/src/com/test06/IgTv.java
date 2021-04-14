package com.test06;

public class IgTv implements TV {

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
