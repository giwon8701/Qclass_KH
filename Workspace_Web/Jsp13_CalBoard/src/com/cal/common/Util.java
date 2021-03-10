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
		// yyyy-MM-dd hh:mm:00 ���·� �ٲ���.
		String temp = mdate.substring(0, 4) + "-"
					+ mdate.substring(4, 6) + "-"
					+ mdate.substring(6, 8) + " "
					+ mdate.substring(8, 10) + ":"
					+ mdate.substring(10) + ":00";
		
		// �������� ǥ������ �ۼ����� : y�� year, M�� month.....
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH��mm��");
		
		// Timestamp : ���ڿ��� Ÿ�ӽ������� ��ȯ����
		Timestamp tm = Timestamp.valueOf(temp);
		
		// tm�� sdf�� �������� ǥ���Ѵ�. -> todates�� ��´�.
		todates = sdf.format(tm);
	}

	// �����, �Ͽ���, ���� ����
	public static String fontColor(int date, int dayOfWeek) {
		String color = "";
		
		if ((dayOfWeek -1 + date)%7 == 0) { // ��ĭ+date(��)�� 7�̸�(���̺��� ���� ���� ��), 7�� �������� 0 -> �����
			color = "blue";
		} else if ((dayOfWeek -1 + date)%7 == 1) {	// ��ĭ+date(��)�� 1�̸�(���̺��� ���� ù��°�� ��), 7�� �������� 1 -> �����
			color = "red";
		} else {
			color = "black";
		}
		
		return color;
	}
	
	// ������(��¥,�ð� ���) ���ڸ��� -> ���ڸ��� ��ȯ
	public static String isTwo(String msg) {
		return (msg.length()<2)? "0" + msg : msg;
	}
	
	// ���� ������ �� ���, �޺κ��� ...����
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
