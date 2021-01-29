package com.test05;

public class SamsongTV implements TV {
	int volume;
	
	public SamsongTV() {
		System.out.println("SamsongTV 구매");
	}
	@Override
	public int volumeUp() {
		volume += 3;
		return volume;
	}

	@Override
	public int volumeDown() {
		volume -= 3;
		return volume;
	}

}
