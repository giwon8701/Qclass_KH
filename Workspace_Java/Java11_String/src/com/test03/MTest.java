package com.test03;

import java.util.StringTokenizer;

public class MTest {

	public static void main(String[] args) {
		String str = "The String class represents character strings.";
		String str02 = "The.String.class.represents.character.strings.";
		
		// 1. java.lang.String.substring(begin, end);
		System.out.println(str.substring(4, 10));
		
		// 2. java.lang.String.split
		String[] temp = str02.split("\\.");
		for (int i=0; i<temp.length; i++) {
			System.out.println(temp[i]);
		}
		
		System.out.println("---------------------------------");
		// 3. java.util.StringTokenizer
		StringTokenizer st = new StringTokenizer(str02, "/.");
		
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
	
}
