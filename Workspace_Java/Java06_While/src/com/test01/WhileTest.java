package com.test01;

public class WhileTest {

	public static void main(String[] args) {
		// 1. 1 ~ 100까지의 숫자를 역순으로 출력하자
		//test01();
		// 2. 1 ~ 100 까지의 숫자 중, 2의 배수만 출력하자.
		//test02();
		// 3. 1 ~ 100 까지의 숫자 중, 7의 배수의 갯수와, 7의 배수의 총 합을 출력하자.
		test03();
	}
	
	public static void test01() {
		int i = 100;
		
		while(i > 0) {
			System.out.println("i = " + i);
			i--;
		}
		
	}
	public static void test02() {
		int i = 1;
		
		while (i > 0) {
			if (i % 2 == 0)
				System.out.println("i = " + i);
			if (i == 100) break;
			
			i++;
		}
	}
	
	public static void test03() {
		int i = 1;
		int count = 0;
		int sum = 0;
		
		while (i <= 100) {
			if (i % 7 == 0) {
				System.out.printf("%d", i);
				count++;
				sum += i;
			}
			
			i++;
		}
		System.out.printf("\n7의 배수의 갯수 : %d\n7의 배수의 총합 : %d", count, sum);
	}
}
