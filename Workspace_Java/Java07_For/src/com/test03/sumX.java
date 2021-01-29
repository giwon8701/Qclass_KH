package com.test03;

public class sumX {

	/*
	 * 1  2  3  4  5
	 * 6  7  8  9  10
	 * 11 12 13 14 15
	 * 16 17 18 19 20
	 * 21 22 23 24 25
	 * 
	 * 이렇게 출력하고,
	 * X의 합을 출력하자.
	 * X의 합 = 117
	 */
	
	public static void main(String[] args) {
		int cnt = 1; // 숫자 카운트
		int row = 1; // 몇번째 줄인지
		int sum = 0; // x의 합
		/*
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=5; j++) {
				System.out.printf("%3d", cnt);
				
				// x자 모양에 겹치는 값 찾기
				// ex) 1번째줄->1 5, 2번째줄->2 4.........
				if((j == row) || (j == 6-row))
					sum += cnt;
				
				// 값 증가
				cnt++;
			}
			System.out.println();
			row++;
		}
		*/
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if ((i == j) || (i + j == 4)) {
					sum += cnt;
				}
				System.out.printf("%3d", cnt++);
			}
			System.out.println();
		}
		// sumX의 값 출력
		System.out.println("sumX의 값 : " + sum);
	}
}
