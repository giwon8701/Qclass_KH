package com.j03;

import java.util.Scanner;

public class Control {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("i 입력 : ");
		int i = sc.nextInt();
		System.out.println("j 입력 : ");
		int j = sc.nextInt();
		
		
		// i의 j제곱을 리턴하는 메소드
		System.out.println("for : " + forTest(i, j));
		System.out.println("while : " + whileTest(i, j));
		
		switchTest(i, j);
		
		// i와 j를 입력했을 때, 무조건 큰수의 작은수 제곱을 해주세요
		ifTest(i, j);
	}
	
	public static void ifTest(int i, int j) {
		if (i > j) {
			System.out.println(Math.pow(i, j));
		} else {
			System.out.println(Math.pow(j, i));
		}
	}
	
	public static void switchTest(int i, int j) {
		switch(i) {
		case 0:
			System.out.println("0은 몇번을 곱해도 0입니다.");
			break;
		case 1:
			System.out.println("1은 몇번을 곱해도 1입니다.");
			break;
			default:
				System.out.println(Math.pow(i, j));
				break;
		}
	}
	
	// Math 클래스를 사용하지 않고, for문과 while문을 사용하여 i의 j제곱을 만들자.
	public static int forTest(int i, int j) {
		int result = 1;
		
		for (int a=0; a<j; a++) {
			result *= i;
		}
		
		return result;
	}
	
	public static int whileTest(int i, int j) {
		int result = 1;
		
		while (j > 0) {
			result *= i;
			j--;
		}
		
		return result;
	}
}
