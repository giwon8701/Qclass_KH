package com.test01;

public class MTest {

	private static String str = "The String class represents character strings.";
	
	public static void main(String[] args) {
		/*
		String s = "Hello";
		System.out.println(s + 1 + 2);
		System.out.println(1 + 2 + s);
		System.out.println(s);
		
		String h = "hello";
		System.out.println(h);
		
		System.out.println(s == h);
		
		String newS = new String("Hello");
		System.out.println(newS);
		
		System.out.println(s == newS);
		
		System.out.println("---------------------");
		*/
		// 1. str의 길이
		test01();
		
		// 2. str 전체 대문자
		test02();
		
		// 3. str 전체 소문자
		test03();
		
		// 4. str에서 첫번째로 나오는 c의 위치(인덱스)
		test04();
		
		// 5. class 단어를 찾아서 java로 바꿔서
		test05();
		
		// 6. character 단어를 찾아서 대문자로 변환 후, 전체 출력
		test06();
		
		// 7. str을 char[]로 출력하되, 'c' 만 출력하자.
		// 그리고 c의 갯수를 출력
		test07();
		
		// 8. str을 char[]로 출력하되, 대문자만 출력하자.
		// 그리고 대문자의 갯수를 촐력
		test08();
		
		// 9. str 사이의 공백 제거 후 출력
		test09();
		
		// 10. 전체를 역순으로 출력
		test10();
	}

	private static void test10() {
		// TODO Auto-generated method stub
		System.out.print("10. 전체를 역순으로 출력 : ");
		for (int i=str.length()-1; i>=0; i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
	}

	private static void test09() {
		// TODO Auto-generated method stub
		System.out.println("9. str 사이의 공백 제거 후 출력 : " + str.replace(" ", ""));
	}

	private static void test08() {
		// TODO Auto-generated method stub
		char[] str_char = str.toCharArray();
		System.out.print("8. str을 char[]로 출력하되, 대문자만 출력 : ");
		for(int i=0; i<str_char.length; i++) {
			if (Character.isUpperCase(str_char[i])) {
				System.out.print(str_char[i]);
			}
		}
		System.out.println();
	}

	private static void test07() {
		// TODO Auto-generated method stub
		char[] str_char = str.toCharArray();
		int cnt = 0;
		System.out.print("7. str을 char[]로 출력하되, 'c' 만 출력 : ");
		for(int i=0; i<str_char.length; i++) {
			if (str_char[i] == 'c' || str_char[i] == 'C') {
				System.out.print(str_char[i]);
				cnt++;
			}
		}
		System.out.print(", c의 갯수 : " + cnt);
		System.out.println();
	}

	private static void test06() {
		// TODO Auto-generated method stub
		//System.out.print("6. character 단어를 찾아서 대문자로 변환 후, 전체 출력 : " + str.replace("character", "CHARACTER"));
		//System.out.println();
		String target = "character";
		int start = str.indexOf(target);
		int end = start + target.length();
		String upper = str.substring(start, end);
		
		upper = upper.toUpperCase();
		
		System.out.println("6. character 단어를 찾아서 대문자로 변환 후, 전체 출력 : " + str.replace(target, upper));
	}

	private static void test05() {
		// TODO Auto-generated method stub
		System.out.println("5. class 단어를 찾아서 java로 바꿔서 : " + str.replace("class", "java"));
	}

	private static void test04() {
		// TODO Auto-generated method stub
		System.out.println("4. str에서 첫번째로 나오는 c의 위치(인덱스) : " + str.indexOf('c'));
	}

	private static void test03() {
		// TODO Auto-generated method stub
		System.out.println("3. str 전체 소문자 : " + str.toLowerCase());
	}

	private static void test02() {
		// TODO Auto-generated method stub
		System.out.println("2. str 전체 대문자 : " + str.toUpperCase());
	}

	private static void test01() {
		// TODO Auto-generated method stub
		System.out.println("1. str의 길이 : " + str.length());
	}
}
