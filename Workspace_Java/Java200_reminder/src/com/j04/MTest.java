package com.j04;

public class MTest {

	public static void main(String[] args) {

		// Person 타입의 값 5개를 받을 수 있는 배열을 만들고,
		// 좋아하는 연예인(캐릭터 ..) 5명을 넣자.

		Person[] people = new Person[5];

		people[0] = new Person("홍길동", 50, 'M');
		people[1] = new Person("신사임당", 40, 'F');
		people[2] = new Person("이순신", 30, 'M');
		people[3] = new Person("김선달", 20, 'M');
		people[4] = new Person("나폴레옹", 10, 'M');

		// 반복문을 사용하여 전체 출력하는데, 나이가 10인 사람은 이름만 출력하자
		/*
		for (int i = 0; i < people.length; i++) {
			if (people[i].getAge() == 10) {
				System.out.println(people[i].getName());
			} else {
				System.out.println(people[i]);
			}
		}
		*/
		for (Person p: people) {
			if (p.getAge() == 10) {
				System.out.println(p.getName());
			} else {
				System.out.println(p);
			}
		}
	}
}
