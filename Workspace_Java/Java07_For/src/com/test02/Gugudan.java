package com.test02;

public class Gugudan {
	public static void main(String[] args) {
		// for문을 사용하여 출력!!!!
		// while문 사용 금지!
		
		// 1. 2단부터 9단까지 전체 출력
		//gugu01();
		
		// 2. 아규먼트로 들어온 값의 단만 출력
		//gugu02(5);
		
		//guguWhile01();
		guguWhile02(5);
		
	}

	public static void gugu01() {
		
		for (int i=2; i<10; i++) {
			System.out.println("<"+i+"단>");
			for (int j=1; j<10; j++) {
				System.out.printf("%d x %d = %d\n", i, j, (i*j));
			}
			System.out.println();
		}
		
	}
	
	public static void gugu02(int dan) {
		System.out.println("<"+dan+"단>");
		for (int i=1; i<10; i++) {
			if (i == 9)
				System.out.printf("%d x %d = %d", dan, i, (dan*i));
			else
				System.out.printf("%d x %d = %d\n", dan, i, (dan*i));
		}
	}
	
	public static void guguWhile01() {
		int dan = 2;
		while (dan < 10) {
			int cnt = 1;
			System.out.println("<"+dan+"단>");
			
			while (cnt < 10) {
				System.out.printf("%d x %d = %d\n", dan, cnt, (dan*cnt));
				cnt++;
			}
			
			System.out.println();
			dan++;
		}
	}
	
	public static void guguWhile02(int dan) {
			int cnt = 1;
			System.out.println("<"+dan+"단>");
			
			while (cnt < 10) {
				System.out.printf("%d x %d = %d\n", dan, cnt, (dan*cnt));
				cnt++;
			}
		}
	}