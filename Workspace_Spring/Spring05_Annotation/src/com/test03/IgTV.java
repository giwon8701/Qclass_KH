package com.test03;

import org.springframework.stereotype.Component;

// IgTv igTV = new IgTV(); => 이름지정안하면 클래스이름 첫글자만 소문자로 변환해줌
@Component
public class IgTV implements TV {
	
	public IgTV() {
		System.out.println("ig tv 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("ig tv power on");
	}

	@Override
	public void powerOff() {
		System.out.println("ig tv power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("ig tv volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("ig tv volume down");
	}

}
