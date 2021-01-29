package com.bbb;

import com.aaa.AAA;

public class MTest {
	
	public static void main(String[] args) {
		// type 변수 = 값;
		// type 변수 = new 생성자();
		AAA myA = new AAA();
		myA.prn();
		AAA paramA = new AAA(10);
		paramA.prn();
		System.out.println("abc : " + paramA.getAbc());
		System.out.println("==============================");
		BBB b1 = new BBB();
		b1.setAbc(10);
		b1.setBcd(20);
		System.out.println(b1.getSum());
		
		BBB b2 = new BBB(15);
		System.out.println(b2.getSum());
		
		BBB b3 = new BBB(20, 50);
		System.out.println(b3.getSum());
		System.out.println("======================");
		
		AAA a1 = new AAA();
		AAA a2 = new BBB(10);
		a1.prn();
		a2.prn();
	}

}
