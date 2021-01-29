package com.test02;

import java.util.ArrayList;
import java.util.List;

public class MTest01 {

	// List
	// 순서 0		중복 0
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		list.add("홍길동");
		list.add("이순신");
		list.add("김선달");
		list.add("강호동");
		list.add("유재석");
		list.add("조세호");
		list.add("신동엽");

		prn(list);
		transElement(list);

	}
	
	private static void transElement(List<String> list) {
		// 1. "홍길동"의 인덱스를 찾아서 해당 인덱스의 값을 "김길동"으로 바꾸자.
		list.set(list.indexOf("홍길동"), "김길동");
		prn(list);
		
		// 2. "~신"으로 끝나는 객체를 찾아서, 만일 있으면 "~자"로 바꾸자.
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).endsWith("신")) {
				list.set(i, list.get(i).replace("신", "자"));
			}
		}
		prn(list);
		
		// 3. 끝 글자가 "호"인 이름을 찾아서 삭제하자.
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).endsWith("호")) {
				list.remove(i);
			}
		}
		prn(list);
	}

	private static void prn(List<String> list) {
		for (String s : list) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
