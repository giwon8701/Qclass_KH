package com.test05;

public class IgTV implements TV {
	int volume;
	
	public IgTV() {
		System.out.println("IgTV 구매");
	}
	@Override
	public int volumeUp() {
		volume += 1;
		return volume;
	}

	@Override
	public int volumeDown() {
		volume -= 1;
		if (volume < 0) {
			volume = 0;
		}
		return volume;
	}

}
