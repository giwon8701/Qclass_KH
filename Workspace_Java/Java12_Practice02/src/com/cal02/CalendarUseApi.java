package com.cal02;

import java.util.Calendar;

// 달력 만들기
// java.util.Calendar 사용해서 만들기
public class CalendarUseApi {

	public void prn(int year, int month) {
		
		// Calendar 객체 생성
		// Calenar cal = new Calendar(); X -> 싱글톤
		Calendar cal = Calendar.getInstance();
		
		// 달력 윗부분
		System.out.printf("\t\t%d년 %d월", year, month);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
		
		cal.set(year,  month -1 , 1);
		
		int start = cal.get(Calendar.DAY_OF_WEEK);
		
		for (int i=1; i<start; i++) {
			System.out.println("\t");
		}
		
		for (int i=1; i<=cal.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%d\t", i);
			if (start % 7 == 0) {
				System.out.println();
			}
			start++;
		}
		
	}
}
