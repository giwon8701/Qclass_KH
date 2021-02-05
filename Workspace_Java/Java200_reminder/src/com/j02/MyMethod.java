package com.j02;

public class MyMethod {
	public static void myPublic() {
		System.out.println("public");
		System.out.println("어디서나 접근 가능");
	}
	
	protected static void myProtected() {
		System.out.println("protected");
		System.out.println("상속 : 상속된 곳에서");
		System.out.println("상속 아닌 경우 : 같은 패키지");
	}
	
	static void myDefault() {
		System.out.println("(default)");
		System.out.println("같은 패키지 내에서");
	}
	
	private static void myPrivate() {
		System.out.println("클래스 내에서만");
	}
	
	public void myNonStatic() {
		System.out.println("(non-static)");
		System.out.println("객체 생성 해야!");
	}
}
