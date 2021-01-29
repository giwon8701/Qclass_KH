package com.test02;

import java.util.Random;

public class RandomCube {

	public static void main(String[] args) {
		/*
		 * 1 ~ 9 사이의 난수로 이루어진
		 * 5 * 5 형태의 숫자들을 출력하고,
		 * 전체 난수의 합,
		 * 전체 난수의 평균,
		 * X의 합
		 * 을 구하자.
		 */
		PrnCube();
	}

	public static void PrnCube() {
		Random ran = new Random();
		int num = 0;
		int cnt = 0;
		int sum = 0;
		double avg = 0;
		int sumX = 0;
		
		for(int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				cnt++;
				
				num = (int)(Math.random()*9) + 1;
				System.out.print(num + " ");
				
				// 전체 합
				sum += num;
				
				// X의 합
				if ((i == j) || (i + j == 4))
					sumX += num;
			}
			System.out.println();
		}
		
		avg = (double)sum / (double)cnt;
		
		System.out.println("전체 난수의 합 : " + sum);
		System.out.printf("전체 난수의 평균 : %.2f\n", avg);
		System.out.println("X의 합 : " + sumX);

/*		
		int ranSum = 0;
		int ranCount = 0;
		double ranAvg = 0;
		int xSum = 0;
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				
				
				// 난수발생
				// 1 ~ 9 : (int)(Math.random() * (9 - 1 + 1)) + 1
				int random = (int)(Math.random()*9) + 1;
				System.out.printf("%2d", random);
				
				// 전체 합
				ranSum += random;
				
				// x의 합
				if ((i == j) || (i + j == 4)) {
					xSum += random;
				}
			
			System.out.println();
		}
		System.out.println("전체 난수의 합 : " + ranSum);
		System.out.println("전체 난수의 평균 : " + ranAvg);
		System.out.println("X의 합 : " + xSum);
		*/
		
	}
	
	
}
