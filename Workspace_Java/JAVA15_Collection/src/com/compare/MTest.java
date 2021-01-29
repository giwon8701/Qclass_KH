package com.compare;

import java.util.Arrays;

public class MTest {

	public static void main(String[] args) {
		Score[] kh = new Score[3];
		kh[0] = new Score("박찬종", 90, 89, 100);
		kh[1] = new Score("임기원", 55, 100, 68);
		kh[2] = new Score("홍길동", 100, 40, 80);
		
		
		for (Score student : kh) {
			System.out.println(student);
		}
		
		Arrays.sort(kh);
		System.out.println("---------------");
		for (Score student : kh) {
			System.out.println(student);
		}
	}
}
