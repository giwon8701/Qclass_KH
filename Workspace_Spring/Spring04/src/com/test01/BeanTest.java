package com.test01;

import java.util.Date;
import java.util.List;

public class BeanTest {
	
	private MyClass myclass;
	
	public BeanTest() {
		System.out.println("BeanTest 기본생성자!");
	}
	
	public BeanTest(MyClass myclass) {
		this.myclass = myclass;
		System.out.println("BeanTest(MyClass) 생성자!");
	}
	
	public BeanTest(Date date) {
		System.out.println("BeanTest(Date) 생성자!");
		System.out.println(date.toLocaleString());
	}
	
	public void setMyclass(MyClass myclass) {
		this.myclass = myclass;
		System.out.println("setMyclass(MyClass myclass) 호출!!");
	}
	
	public void setDate(Date date) {
		System.out.println("setDate(Date date) 호출!!");
		//System.out.println("today : " + date.toLocaleString());
		System.out.println("end : " + date.toLocaleString());
	}
	
	public void setNumber(int num) {
		System.err.println("setNumber(int num) 호출 : " + num);
	}

	public void setArray(String[] arr) {
		System.out.println("setArray(String[] arr) 호출");
		for (String s : arr) {
			System.out.println(s);
		}
	}
	public void setList(List<String> list) {
		System.out.println("setArray(String[] arr) 호출");
		for (String s : list) {
			System.out.println(s);
		}
	}

}
