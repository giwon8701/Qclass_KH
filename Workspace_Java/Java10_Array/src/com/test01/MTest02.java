package com.test01;

import java.util.Arrays;

public class MTest02 {

	public static void main(String[] args) {
		
		// 방법 1.
		int [][]a = new int[3][2];
		a[0][0] = 1;
		a[0][1] = 2;
		a[1][0] = 3;
		a[1][1] = 4;
		a[2][0] = 5;
		a[2][1] = 6;
		
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.deepToString(a));
	
		// 방법 2.
		int[][] b = new int[3][];
		b[0] = new int[3];
		b[1] = new int[5];
		b[2] = new int[1];
		
		// 방법 3.
		int[][] c = new int[][] { {1, 2}, {3, 4, 5}, {6, 7, 8, 9}, {10} };
		
		// 방법 4.
		int[][] d = { {1, 2, 3, 4}, {5}, {6, 7, 8}, {9, 10} };
		
		// c가 가진 8 + d가 가진 9 출력
//		System.out.println(c[2][2] + d[3][0]);
		
		// c의 length
//		System.out.println(c.length);
		// c 내부의 배열의 length
//		System.out.println(c[0].length);
//		System.out.println(c[1].length);
//		System.out.println(c[2].length);
//		System.out.println(c[3].length);
		
		prn(a);
		prn(b);
		prn(c);
		prn(d);
		
		String[][] s = {{"Have", "a", "nice", "Day"}, {"너무", "어려워"}, {"일차원", "배열", "이차원", "배열"}};
		
		modi(s);
	}
	
	public static void modi(String[][] arr) {
		// nice -> good
		// 어려워 -> 쉬워
		arr[0][2] = "good";
		arr[1][1] = "쉬워";
		
		// 출력 예)
		// Have a good day
		// 너무 쉬워
		// 일차원 배열 이차원 배열
		for (int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("%s ", arr[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void prn(int[][] arr) {
		// [ {1, 2, 3, 4},
		//   {5},
		//   {6, 7, 8},
		//   {9, 10}
		// ]
		System.out.println("[");
		for (int i=0; i<arr.length; i++) {
			System.out.print("{");
			for (int j=0; j<arr[i].length; j++) {
				if (j == arr[i].length-1)
					System.out.printf("%d", arr[i][j]);
				else
					System.out.printf("%d, ", arr[i][j]);
			}
			if (i == arr.length-1)
				System.out.println("}");
			else
				System.out.println("}, ");
		}
		System.out.println("]");
	}
}
