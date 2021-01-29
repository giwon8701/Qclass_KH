package com.test02;

public class MTest {

	public static void main(String[] args) {
		/*
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		cat.bark();
		dog.bark();
		*/
		
		Animal animal = new Dog();
		animal.bark();
		
		animal = new Cat();
		animal.bark();
		
		// instanceof : 해당 타입의 객체인지 아닌지 판별
		if (animal instanceof Dog) {
			System.out.println("멍멍이다!");
		} else if (animal instanceof Cat) {
			System.out.println("야옹이다!");
		}
		
		
		/*
		 * 다형성
		 * 1. 부모의 타입으로 자식 생성
		 * Parent p = new Child();
		 * 
		 * 2. 부모의 이름으로 자식 대입
		 * Child c = new Child();
		 * Parent p = c;
		 * 
		 * 3. 부모의 메소드를 통해 자식의 메소드 호출
		 * 
		 * 같은 부모를 상속받은 자식 클래스는, 컴파일 시 형변환 가늫안 것처럼 작성되지만,
		 * 실행시(runtime)시 ClassCastException을 발생시킴.
		 */
	}
}
