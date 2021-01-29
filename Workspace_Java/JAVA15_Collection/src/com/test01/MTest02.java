package com.test01;

import java.util.Vector;

public class MTest02 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();

		v.add("홍길동");
		v.add("이순신");
		v.add("김선달");
		v.add("강호동");
		v.add("유재석");
		v.add("신동엽");
		v.add("조세호");

		transElement(v);
		prn(v);
	}

	public static void prn(Vector<String> vector) {

		// 향상된 for문(foreach)
		for (String s : vector) {
			System.out.print(s + " ");
		}
	}

	public static void transElement(Vector<String> vector) {
		// 1. 홍길동의 인덱스를 찾아서, 해당 인덱스의 값을 "홍길순"으로 바꾸자
		vector.set(vector.indexOf("홍길동"), "홍길순");

		// 2. "~신"으로 끝나는 객체를 찾아서, 만일 있으면 "신" -> "자" 로 바꾸자.
		for (int i=0; i<vector.size(); i++) {
			if(vector.get(i).endsWith("신")) {
				vector.set(i, vector.get(i).replace("신", "자"));
			}
		}

		// 3. 마지막 글자가 "호"인 이름을 찾아서, 만일 있으면 삭제하자.
		for (int i=0; i<vector.size(); i++) {
			if(vector.get(i).endsWith("호"))
				vector.remove(i);
		}
		
		
	}
}
