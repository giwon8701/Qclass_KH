package com.j05;

public class MTest {

	public static void main(String[] args) {
		
		// 비버랑 독수리랑 객체 만들어서
		// 비버의 울음소리: ??
		// 독수리의 울음소리: ??
		
		Animal beaver = new Beaver("비버", 10);
		Animal eagle = new Eagle("독수리", 20);
		
		beaver.bark("비어비어");
		eagle.bark("이글이글");
	}
}