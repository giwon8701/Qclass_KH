package com.test02;

public class PrnTest {

	/*
	 * System.out.print() - 줄 바꿈 없음
	 * System.out.println() - 줄 바꿈 포함
	 * 
	 * System.out.printf
	 */
	
	public static void main(String[] args) {
		int i = 100;
		
		System.out.print("1. i: \\" + i + "\n");
		System.out.println("2. i: \t" + i);
		System.out.printf("3. i: %d", i);
		System.out.println("------------");
		
		// 시험 점수 결과는 100(su)점 이고, 학점은 'A(ch)' 가 나왔다.
		// 나의 오늘 감정지수는 90.50(d) 이다.
		int su = 100;		// 10자리
		char ch = 'A';		// 5자리
		double d = 90.50d;	// 5자리(소수점 2자리)
		// System.out.printf() 를 쓰자.
		
		
		System.out.printf("시험 점수 결과는 %10d점 이고, 학점은 %c가 나왔다.\n",  su, ch);
		System.out.printf("나의 오늘 감정지수는 %5.2f%%이다.", d);
		
		
		// 오늘은 11/24 입니다. 제 나이는 00(age)입니다. 제 이름은 oo(name)입니다.
		int age = 100;
		String name = "이동헌";
		System.out.printf("오늘은 11\\24 입니다. 제 나이는 %d 입니다. 제 이름은 %s 입니다.", age, name);
		
		
	}
}
