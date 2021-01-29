package com.test06;

import java.util.Scanner;

public class Circle extends AreaImpl {
	
	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("반지름을 입력해 주세요 : ");
		int rad = sc.nextInt();
		double area =  Math.PI * Math.pow(rad, 2);

		setResult(String.format("%.2f", area));
		sc.close();
	}

	public void print() {
		System.out.printf("원의 ");
		super.print();
	}
}
