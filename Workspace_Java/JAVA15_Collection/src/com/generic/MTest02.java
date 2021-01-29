package com.generic;

import java.util.ArrayList;
import java.util.List;

public class MTest02 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		// list.add(3);
		list.add("4");
		list.add("5");
		// list.add('6');

		for (int i = 0; i < list.size(); i++) {
			System.out.println(((String) list.get(i)).getBytes());
		}

	}
}
