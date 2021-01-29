package com.test01;

import java.util.Scanner;

public class MTest02 {

	public static int inputInt() {
		int res = 0;
		
		System.out.println("숫자를 입력해 주세요 : ");
		Scanner sc = new Scanner(System.in);
		res = sc.nextInt();
		
		return res;
	}
	
	public static int sum(int a,  int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		
		while(true) {
			int a = inputInt();
			int b = inputInt();
			int sum = sum(a, b);
			System.out.printf("%d + %d = %d\n", a, b, sum);
			if (a == 3 || b == 3) {
			System.out.println("게임을 종료합니다.");
			break;
			}
		}
	}
}
