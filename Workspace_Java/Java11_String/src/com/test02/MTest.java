package com.test02;

public class MTest {
	public static void main(String[] args) {
//		sTest();
		sBufferTest();
	}
	
	/*
	 * String
	 * - immutable
	 * 참조 -> 기본
	 * 
	 * StringBuilder - single thread
	 * StringBuffer  - multi thread
	 * - mutable
	 * - 대입하지 않아도 값이 바뀜
	 */

	// string을 +연산으로 연결할 때, 내부적으로 StringBuilder로 더해준다. (jdk 1.5)
	public static void sTest() {
		// immutable
		String s = "안녕하세요.";
		s += "저는 ";
		s += "임기원 입니다.";
		
		System.out.println(s);
		System.out.println(s.hashCode());
		
		System.out.println(s.replace("안녕하세요.", "하이!"));
		System.out.println(s);
		
		s = s.replace("안녕하세요", "하이");
		System.out.println(s);
		System.out.println(s.hashCode());
	}
	
	public static void sBufferTest() {
		// mutable
		StringBuffer sb = new StringBuffer();
		sb.append("안녕하세요").append(" 저는 ").append("임기원입니다.");
		
		System.out.println(sb.hashCode());
		System.out.println(sb);
		
		sb.replace(0, 5, "하이");
		System.out.println(sb);
		
		// 거꾸로 출력
		sb.reverse();
		System.out.println(sb);
		
	}
}
