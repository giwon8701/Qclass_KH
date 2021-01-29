package com.test05;

public class School {
	
	// 1. 어디서나 접근할 수 있고, static으로 선언되어 있으며,
	// 리턴 타입은 없는 namePrn 이라는 메소드를 만들자.
	// 파라미터는 String 하나 받을 거고,
	// 받은 값을 가지고 내 이름은 ??? 입니다." 라고 출력하자. (System.out.printf 사용하기!)
	
	/*
	 * 2. 어디서나 접근할 수 있고, static으로 선언되어 있으며,
	 * 리턴 타입은 int인 getAge 라는 메소드를 만들자.
	 * 파라미터는 없고, 자신의 나이를 리턴하자.
	 * 
	 * 3. 같은 패키지 내에서만 접근 할 수 있고, non-static 이며,
	 * 리턴 타입은 없는 addrPrn이라는 메소드를 만들자.
	 * 파라미터는 String 하나 받을 거고,
	 * 받은 값을 가지고 "우리 집은 ??? 입니다." 라고 출력하자. (System.out.printf 사용하기!)
	 */
	
	public static void namePrn(String name) {
		System.out.printf("내 이름은 %s 입니다.\n", name);
	}
	
	public static int getAge() {
		int age = 27;
		return age;
	}
	
	void addrPrn(String addr) {
		System.out.printf("우리 집은 %s 입니다.\n", addr);
	}
	

}
