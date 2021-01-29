package com.test03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.score.Score;

public class MTest02 {

	public static void main(String[] args) {
		// Score 객체 만들자
		// 이름은 홍길동, 이순신, 김선달. 점수는 알아서
		Score s1 = new Score();
		s1.setName("홍길동");
		s1.setKor(100);
		s1.setEng(56);
		s1.setMath(70);
		
		Score s2 = new Score("이순신", 57, 81, 100);
		Score s3 = new Score("김선달", 79, 100, 50);
		
		// Score 객체를 관리할 수 있는 Set 객체를 만들자.
		// Set type에, HashSet으로 만들자.
		Set<Score> set = new HashSet<Score>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(new Score("샤넬", 100, 100, 100));
		
		//printCollection(set);
		transElement(set, "홍길동", 10);
	}
	
	public static void transElement(Set<Score> set, String target, int kor) {
		// set에서 홍길동을 찾아서 국어점수를 10점으로 바꾸고 전체출력
		// 찾을때 iterator를 사용하자!
		Iterator<Score> find = set.iterator();
		while(find.hasNext()) {
			/*
			if (find.next().getName() == target) {
				find.next().setKor(kor);
			}
			*/
			Score temp = find.next();
			if (temp.getName().equals(target)) {
				temp.setKor(kor);
			}
		}
		
		// 출력
		Iterator<Score> ir = set.iterator();
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
	}
	
	
	public static void printCollection(Set<Score> set) {
		// 1. 
		for (Score sc : set) {
			System.out.println(sc);
		}
		System.out.println("----------------");
		// 2. 
		Object[] oArr = set.toArray();
		for(int i=0; i<oArr.length; i++) {
			//System.out.println(oArr[i]);
			System.out.println( ((Score)oArr[i]).getName() + "\t" + ((Score)oArr[i]).getAvg() );
		}
		System.out.println("==================");
		// 3. Iterator : 컬렉션 저장 요소를 읽어오는 표준화된 방법
		Iterator<Score> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
