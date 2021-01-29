package com.test03;

import java.util.HashSet;
import java.util.Set;

public class MTest01 {

	
	// Set : 순서 x, 중복 x
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("1");
		set.add("3");
		set.add("5");
		set.add("2");
		set.add("4");
		set.add("6");
		set.add("7");
//		set.add(null);
		
		for (String s : set) {
			System.out.println(s + " ");
		}
		System.out.println();
		
		findElement(set, "3");
		deleteElement(set, "3");
	}
	
	public static void deleteElement(Set<String>set, String delete) {
		for (String s : set) {
			if (s.equals(delete)) {
				set.remove(s);
				System.out.println(s + " 지웠다!!");
				break;
			}
		}
	}
	
	public static void findElement(Set<String> set, String find) {
		/*
		for (int i = 0; i < set.size(); i++) {
			set.get(i);
		}
		*/
		
		for (String s : set) {
			if (s.equals(find)) {
				System.out.println(find + " 찾았다!!");
			}
		}
	}
}
