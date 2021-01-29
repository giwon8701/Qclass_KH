package com.test02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MTest02 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		for (int i = 10; i > 0; i--) {
			list.add(i + "");
		}

		System.out.println(list);
		Collections.sort(list, new MySort());
		System.out.println(list);
	}
	
	
}

class MySort implements Comparator<String> {

	/*
	 * 1  이면 앞의 인자가 더 큰값
	 * 0  이면 같은 값
	 * -1 이면 뒤의 인자가 더 큰값
	 */
	@Override
	public int compare(String o1, String o2) {

		int tmp1 = Integer.parseInt(o1);
		int tmp2 = Integer.parseInt(o2);
		
		// ?
		if (tmp1 > tmp2) {
			return 1;
		} else if (tmp1 < tmp2) {
			return -1;
		}
		
		return 0;
	}
	
	
}