package com.test01;

public class MethodTest01 {
	
	// main method : 프로그램의 주 진입점
	public static void main(String[] args) {
		// class.method();
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		// 같은 클래스 내부에 있는 메소드를 호출할 때는, class 생략 가능!
		defaultMethod();
		privateMethod();
		
	}
	
	// method : 기능, 명령문들의 집합
	// 접근제한자 메모리영역 리턴타입 메소드명 (파라미터) {}
	
	// public : 어디서나 접근, 참조 가능(+)
	public static void publicMethod() {
		System.out.println("public method 호출!");
	}
	
	// protected : 상속일 경우 상속된 곳에서, 상속이 아닌 경우 같은 패키지 내에서 (#)
	protected static void protectedMethod() {
		System.out.println("protected method 호출!");
	}
	
	// (default) : 같은 패키지 내에서만 (~)
	static void defaultMethod() {
		System.out.println("default method 호출!");	
	}
	
	// private : 현재 클래스 내에서만 (-)
	private static void privateMethod() {
		System.out.println("private method 호출!");
	}
	
	// non-static method : 객체 필요
	public void nonstaticMethod() {
		System.out.println("MethodTeset01의 non-static method 호출!");
	}
	
}
