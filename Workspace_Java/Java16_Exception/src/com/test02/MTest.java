package com.test02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MTest {

	public static void main(String[] args) {
		int a = 0;

		try {
			System.out.println("숫자를 입력해 주세요.");
			Scanner sc = new Scanner(System.in);
			a = sc.nextInt();
			
			int result = 1 / a;
			
			if (a == 100) {
				throw new MyException();
			}
			
			if (a == 666) {
				throw new InputMismatchException();
			}
			
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력해 주세요.");
		} catch (MyException e) {
			e.printStackTrace();
			System.out.println("100을 입력하셨습니다.");
		} catch (Exception e) {
			System.out.println("예외가 발생했습니다.");
		}
		
		System.out.println(a);
	}
}
