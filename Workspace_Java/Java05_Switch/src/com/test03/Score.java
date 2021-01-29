package com.test03;

public class Score {
	
	/*
	 * 1. int형 값 3개를 받아서, 3으로 나눠서 평균 값을 리턴하는 getAvg 라는 메소드를 만들자.
	 * 접근은 어디서나 가능하며, non-static으로 만들자
	 */
	public double getAvg(int kor, int eng, int math) {
		int sum = kor + eng + math;
		double res = (double)sum / 3;
		
		return res;
	}
	
	
	
	/*
	 * 2. double형 평균값 하나를 받아서,
	 * 값이 90 ~ 100 사이면 "A"
	 * 80 ~ 89 면 "B"
	 * 70 ~ 79 면 "C"
	 * 60 ~ 69 면 "D"
	 *    ~ 59 면 "F"
	 * 를 리턴하는 getGrade 메소드 만들자.
	 * 어디서나 접근 가능하며, non-static으로 만들자.
	 * 그리고, 기능은 switch로 만들자 (if 사용 금지!)
	 */
	public String getGrade(double avg) {
		int score = (int)avg/10;
		char grade = ' ';
		
		switch (score) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			grade = 'F';
			break;
		default:
			grade = 'X';
			break;
		}
		
		return String.valueOf(grade);
	}
	
	// 3. MTest의 main 메소드에서 getAvg와 getGrade를 사용하여 홍길동과 이순신의 등급을 출력하자.

}
