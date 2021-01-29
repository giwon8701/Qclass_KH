package com.test01;

public class MethodTest02 {
	
	public static void main(String[] args) {
		// method  호출 방법
		// 1. static method : class.method();
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		MethodTest01.defaultMethod();
		// MethodTest01.privateMethod();
		// MethodTest01.abc();
		
		// 2. non-static method
		// class(참조타입) 변수 = new class();
		// 변수.method();
		MethodTest01 method01 = new MethodTest01();
		method01.nonstaticMethod();
	}

}
