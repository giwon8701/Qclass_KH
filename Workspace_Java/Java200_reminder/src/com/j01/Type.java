package com.j01;

public class Type {

	public static void main(String[] args) {
		// type 변수 = 값;
		int i = 10;
		String s = "20";
		
		int res = i + Integer.parseInt(s);
		System.out.println(res);
		
		String s1 = new String("a");
		String s2 = "a";
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}
}
