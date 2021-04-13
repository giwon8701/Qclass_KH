package com.test03;

public class Person {

	private String name;
	private int age;
	
	public Person() {
		
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void sayHello() {
		System.out.printf("내 친구 %s는 %d 살 입니다.\n", name, age);
	}
}
