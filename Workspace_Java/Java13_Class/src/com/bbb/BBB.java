package com.bbb;

import com.aaa.AAA;

// super : 부모 (상속)
public class BBB extends AAA {

	private int bcd;
	
	public BBB() {
		System.out.println("BBB생성");
	}
	
	public BBB(int abc) {
		super(abc);
		bcd = 10;
		System.out.println("BBB생성 -> abc : " + abc);
	}
	
	public BBB(int abc, int bcd) {
		super(abc);
		this.bcd = bcd;
		System.out.printf("BBB생성 -> abc : %d, bcd : %d\n", abc, bcd);
	}
	
	public int getBcd() {
		return bcd;
	}
	public void setBcd(int bcd) {
		this.bcd = bcd;
	}
	
	public int getSum() {
//		int sum = super.getAbc() + this.getBcd();
		int sum = getAbc() + getBcd();
		return sum;
	}
	
	@Override
	public void prn() {
		System.out.println("BBB.prn()");
	}
}
