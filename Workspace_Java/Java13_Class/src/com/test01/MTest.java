package com.test01;

public class MTest {

	public static void main(String[] args) {
		AA a = new AA();
		Super s = a;			// Super s에다가 a가 가진 new AA()한 "instance"의 주소값 대입
//		BB b = (BB) s;			// s에 담긴 AA instance를 BB로 형변환
		
		System.out.println(a.hashCode());
		System.out.println(s.hashCode());
	}
}
