package com.test01;

public class Type02 {
	
	// 정수형 type : byte, short, int, long
	public static void main(String[] args) {
		
		// type variable = literal;
		// 타입 변수 = 값;
		
		byte b01 = 126;
		System.out.println(b01);
		b01 = 111;
		System.out.println(b01);
		
		byte b02 = (byte) 128;	// 형 변환 : casting
		System.out.println(b02);
		
		byte sumB = (byte) (b01 + b02);
		System.out.println(sumB);
		
		System.out.println("--------------------");
		
		short s1 = 32767;
		System.out.println("s1 = "+s1);
		short s2 = 2;
		System.out.println("s2 = "+s2);
		
		short sumS = (short)(s1 + s2);
		// short는 -32768 ~ 32767 라서
		// 32767 + 2 => 32767 + 1 + 1 => -32767 + 1 
		System.out.println("sumS = "+sumS);
		
		// int 는 정수형의 기본
		int i = 10;
		int j = 20;
		int sum = i + j;
		System.out.println("sum = "+sum);
		
		i = 30;
		sum = i + j;
		System.out.println("sum = "+sum);
		
/*----------+연산자는 기본형이 int다!--------*/		
		byte a = 10;
		byte b = 20;
		byte sumb = (byte)(a + b);
		System.out.println(sumb);
/*---------------------------------------*/
		
		System.out.println("---------------------");
		
		long l1 = 300000000000l;
		long l2 = 400000000000L;
		long sumL = l1 + l2;
		System.out.println("sumL = "+sumL);
		
		System.out.println("\n진수별 표기");
		//2진수(ob)
		System.out.println("0b10 = "+0b10);
		//8진수(00)
		System.out.println("0010 = "+0010);
		//16진수(0x)
		System.out.println("0x10 = "+0x10);
		
		
	}

}
