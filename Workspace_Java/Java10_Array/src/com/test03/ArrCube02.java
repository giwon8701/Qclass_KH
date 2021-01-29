package com.test03;

public class ArrCube02 {
	/*
	 *  1  2  3  4  5
	 * 10  9  8  7  6
	 * 11 12 13 14 15
	 * 20 19 18 17 16
	 * 21 22 23 24 25
	 * 
	 * 모양의 이차원 배열을 만들어서 출력하자
	 */
	
	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20},
				{21, 22, 23, 24, 25}
		};
		arr_cube(arr);
	}
	
	public static void arr_cube(int[][] arr) {
		
		for (int i=0; i<arr.length; i++) {
			
			// 배열의 첫번째가 홀수 일때
			if ((arr[i][0] % 2)  != 0) {
				// 순차적으로 배열 출력
				for (int j=0; j<arr[i].length; j++) {
					if (j == arr[i].length-1)
						System.out.printf("%2d\n", arr[i][j]);
					else
						System.out.printf("%2d ", arr[i][j]);
				}
			}
			// 배열의 첫번째가 짝수일때
			else {
				// 역순으로 배열 출력
				for (int j=arr[i].length-1; j>=0; j--) {
					if (j == 0)
						System.out.printf("%2d\n", arr[i][j]);
					else
						System.out.printf("%2d ", arr[i][j]);
				}
			}
		}
	}
}
