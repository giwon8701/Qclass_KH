package com.test03;

public class MTest {
	
	public static void main(String[] args) {
		int myMul = MyCalc.sum(10,  2);
		System.out.println(myMul);
		
		
		
		// mul 메소드 호출하는데
		// 아규먼트는 10, 3
		// 호출해서 리턴된 결과 값을
		// console에 출력하자
		double Mul = MyCalc.mul(10,  3);
		System.out.println(Mul);
		
		
		// MyCalc.div(10, 4);
		MyCalc calc = new MyCalc();
		calc.div(10, 3);
	}

}
