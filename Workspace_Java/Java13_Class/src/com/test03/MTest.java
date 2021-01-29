package com.test03;

public class MTest {

	public static void main(String[] args) {
		MySum my = new MySum();
		
		System.out.println(my.sum(1));
		System.out.println(my.sum(2, 3));
		System.out.println(my.sum(4, 5, 6));
		System.out.println(my.sum(7.8, 9.1));
		System.out.println(my.sum(10.1, 23.4, 56.7));
	}
}
