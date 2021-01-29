package com.cal;

import java.util.Scanner;

// 달력 만들어 주세요.
// java.util.Calendar 금지! (다른 package도 모두 금지)
public class DayOfCalendar {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도 입력 : ");
		int year = sc.nextInt();
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		System.out.println("일 입력 : ");
		int day = sc.nextInt();
		sc.close();
		
		int sum = 0;
		
		// ex) 2020/12/01
		// 2019년까지 반복
		for (int i=1; i<year; i++) {
			for (int j=1; j<=12; j++) {
				sum += getDates(i, j);
			}
		}
		// 11월까지 반복 
		for (int k=1; k<month; k++) {
			sum += getDates(year, k);
		}
		
		//														  {(0001/01/01 ~ 2020/11/30) + 1(12/01이라서 1일만 더해줌)}의 나머지 계산 => 요일
		System.out.printf("%d 년 %d 월 %d 일은 %s 입니다.\n", year, month, day, dayCharacter((sum + day)%7));
		
		// 달력 출력
		cal(year, month, day, sum);
		
	}
	// 무슨 요일인지 출력
	public static String dayCharacter (int day) {
		
		switch(day) {
		case 0:
			return "일요일";
		case 1:
			return "월요일";
		case 2:
			return "화요일";
		case 3:
			return "수요일";
		case 4:
			return "목요일";
		case 5:
			return "금요일";
		case 6:
			return "토요일";
		}
		
		return null;
	}
	// 입력한 달의 마지막 날짜 출력
	public static int getDates(int year, int month) {
		int result = 0;
		
		if (isLeapYear(year)) {
			
			switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				result = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				result = 30;
				break;
			case 2:
				result = 29;
				break;
			}
		} else {
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				result = 31;
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				result = 30;
			} else if (month == 2) {
				result = 28;
			}
		}
		
		return result;
	}
	// 윤년 판별
	public static boolean isLeapYear(int year) {
		boolean isLeap = false;
		
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			isLeap = true;
		}
		
		return isLeap;
	}
/*--------------------------CALENDAR----------------------------------*/
	// 달력 출력
	public static void cal(int year, int month, int day, int sum) {
		System.out.println();
		String[] arr = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		// 무슨 요일인지 날짜에 표시해줌
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%-4s", arr[i]);
		}
		System.out.println("\n-----------------------------");
		
		for (int i=1; i<=getDates(year, month); i++) {
			// 1일의 경우, 밀린 요일만큼 띄어쓰기해줌
			if(i == 1) {
				for(int j=0; j<(sum+i)%7; j++) {
					System.out.print("    ");
				}
			}
			
			// 토요일인 경우 개행해줌
			if (dayCharacter((sum+i)%7) == "토요일")
				System.out.printf("%-4d\n", i);
			else
				System.out.printf("%-4d", i);
		}
	}
/*--------------------------------------------------------------------*/
}
