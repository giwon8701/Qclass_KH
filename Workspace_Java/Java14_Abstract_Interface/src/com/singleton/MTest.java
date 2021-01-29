package com.singleton;

public class MTest {

	public static void main(String[] args) {
		
		//Singleton singleton = new Singleton();
		Singleton s1 = Singleton.getInstance();
		System.out.println(s1);
		System.out.println(s1.hashCode());
		
		Singleton s2 = Singleton.getInstance();
		System.out.println(s2);
		System.out.println(s2.hashCode());
	}
}
