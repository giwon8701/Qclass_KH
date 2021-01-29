package com.test03;

public class ArrCube01 {
	/*
	 * 1 4 7
	 * 2 5 8
	 * 3 6 9
	 * 
	 * 모양의 배열을 만들어서 출력하자
	 */

	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		arr_sqr(arr);
	}
	
	public static void arr_sqr(int arr[][]) {
		
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.printf("%-2d", arr[j][i]);
			}
			System.out.println();
		}
		
	}
	
	
	/*
	 
	 public static void main(String[] args) {
	 	int[][] arr = new int[3][3];
	 	int cnt = 1;
	 	
	 	// 만들기
	 	for (int i=0; i<arr.length; i++) {
	 		arr[j][i] = cnt++;
	 		}
	 	}
	 	
	 	// 출력하기
	 	 * for (int i=0; i<arr.length; i++) {
	 		for (int j=0; j<arr[i].length; j++) {
	 			System.out.printf("%-2d", arr[i][j]);
	 		}
	 	   }
	 	   System.out.println();
	 }
	 
	 */
	
}
