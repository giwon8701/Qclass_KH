package com.test02;

public class Season {

	public static void main(String[] args) {
		
		System.out.println("11월은 " + Season.prn(13) + " 입니다.");
		/*
		 * Season class에 prn 메소드를 만들자.
		 * parameter로 int형 값 하나를 받아서,
		 * 해당 값이 12, 1, 2라면 "겨울" 리턴
		 * 3, 4, 5 라면 "봄" 리턴
		 * 6, 7, 8 라면 "여름" 리턴
		 * 9, 10, 11 라면 "가을" 리턴
		 * 1 ~ 12 사이의 값이 아니라면 "1~12 사이의 값만 입력해 주세요." 리턴
		 * 
		 * switch 사용해서 문제 풀기!
		 */
		
	}
	
	public static String prn(int i) {
		
		String season = null;
		
		switch(i) {
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
			
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
			
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
			
		case 9:
		case 10:
		case 11:
			season = "겨울";
			break;
			
		default:
			System.out.println("1~12 사이의 값만 입력해 주세요.");
			break;
		}
		
		return season;
	}
}
