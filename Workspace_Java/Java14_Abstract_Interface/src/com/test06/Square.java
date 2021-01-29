package com.test06;

import java.util.Scanner;

public class Square extends AreaImpl {

	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("밑변을 입력해 주세요 : ");
		int width = sc.nextInt();
		
		System.out.print("높이를 입력해 주세요 : ");
		int height = sc.nextInt();
		
		int area = width * height;

		setResult(Integer.toString(area));
		
		sc.close();
	}

	public void print() {
		System.out.print("사각형의");
		super.print();
	}
}
