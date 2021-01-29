package com.test05;

public class MTest {
	
	// School class에 만들어 놓은 1번 2번 3번 메소드를 호출하여 console에 출력하자.
	
	public static void main(String[] args) {

		School.namePrn("임기원");
		int age = School.getAge();
		System.out.println(age + "세");
		School kh = new School();
		kh.addrPrn("서울시");
				
	}

}
