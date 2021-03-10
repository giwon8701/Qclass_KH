package com.cal.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cal.dto.CalDto;

public class Util {
	
	private String todates;
	
	public String getTodates() {
		return todates;
	}
	public void setTodates(String mdate) {
		// yyyy-MM-dd hh:mm:00 형태로 바꾸자.
		String temp = mdate.substring(0, 4) + "-"
					+ mdate.substring(4, 6) + "-"
					+ mdate.substring(6, 8) + " "
					+ mdate.substring(8, 10) + ":"
					+ mdate.substring(10) + ":00";
		
		// 어떤방식으로 표현할지 작성해줌 : y는 year, M은 month.....
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분");
		
		// Timestamp : 문자열을 타임스탬프로 변환해줌
		Timestamp tm = Timestamp.valueOf(temp);
		
		// tm을 sdf의 포맷으로 표현한다. -> todates에 담는다.
		todates = sdf.format(tm);
	}

	// 토요일, 일요일, 평일 색상
	public static String fontColor(int date, int dayOfWeek) {
		String color = "";
		
		if ((dayOfWeek -1 + date)%7 == 0) { // 빈칸+date(일)이 7이면(테이블의 가장 끝일 때), 7로 나눴을때 0 -> 토요일
			color = "blue";
		} else if ((dayOfWeek -1 + date)%7 == 1) {	// 빈칸+date(일)이 1이면(테이블의 가장 첫번째일 때), 7로 나눴을때 1 -> 토요일
			color = "red";
		} else {
			color = "black";
		}
		
		return color;
	}
	
	// 일정의(날짜,시간 등등) 한자리수 -> 두자리수 변환
	public static String isTwo(String msg) {
		return (msg.length()<2)? "0" + msg : msg;
	}
	
	// 일정 제목이 긴 경우, 뒷부분을 ...으로
	public static String getCalView(int i, List<CalDto> list) {
		
		String d = isTwo(i+"");
		String res = "";
		
		for (CalDto dto : list) {
			if (dto.getMdate().substring(6, 8).equals(d)) {
				res += "<p>"
					 + ((dto.getTitle().length() > 6)? dto.getTitle().substring(0, 6)+"..." : dto.getTitle())
					 + "</p>";
			}
		}
		
		return res;
	}
	
	
	
	
	
}
