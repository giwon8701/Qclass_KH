package com.singleton;

// singleton pattern : 메모리(heap)에 객체를 한번만 생성
public class Singleton {
	
	
	// 2. 객체를 확인할 주소(reference) 변수 선언
	private static Singleton singleton;
	
	// 1. 생성자를 외부에서 사용할 수 없도록 private으로 선언
	private Singleton() {
		System.out.println("singleton instance 생성");
	}
	
	// 3. 객체가 heap에 있는지 확인
	// 있으면 주소값 리턴, 없으면 새로운 객체 생성
	public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new Singleton();
			System.out.println("new!");
		} else {
			System.out.println("exist!");
		}
		
		return singleton;
	}
}
