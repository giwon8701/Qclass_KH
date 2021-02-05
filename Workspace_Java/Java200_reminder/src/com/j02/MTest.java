package com.j02;

public class MTest {

	public static void main(String[] args) {
		MyMethod.myPublic();
		MyMethod.myProtected();
		MyMethod.myDefault();
		//MyMethod.myPrivate();
		
		MyMethod my = new MyMethod();
		my.myNonStatic();
	}
}
