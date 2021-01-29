package com.test01;

public class Type04 {

	public static void main(String[] args) {
		//문자형
		char c1 = 'a';
		System.out.println("c1 = "+c1);
		char c2 = 'b';
		int i1 = c2;
		System.out.println("i1 = "+i1);		// ascii code!!!!!
	
		//문자열
		String s1 = "aa";
		System.out.println(s1);
		String s2 = "bb";
		System.out.println(s2);
		String sumS = s1 + s2;
		System.out.println("sumS = "+sumS);
		
		String s3 = "1";
		String s4 = "2";
		String sumS2 = s3 + s4;
		System.out.println("sumS2 = "+sumS2);
		
		
		//논리형
		boolean b1 = true;
		boolean b2 = false;
		System.out.println(b1);
		System.out.println(b2);
		
		
		//unicode
		// %JAVA_HOME\bin\native2ascii.exe
	
	}
	
}
