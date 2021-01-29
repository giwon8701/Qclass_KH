package com.generic;

public class MTest {

	public static void main(String[] args) {
		Emp emp = new Emp();
		emp.setEmpno(111);
		emp.setEname("홍길동");
		System.out.println(emp.getEname() + ":" + emp.getEmpno());
		
		Emp emp2 = new Emp("112a", "김선달");
		System.out.println(emp2.getEname() + ":" + emp2.getEmpno());
		
		Emp<String> emp3 = new Emp<String>("113a", "이순신");
		System.out.println(emp.getEname() + ":" + emp3.getEmpno());
		
		// Emp<Integer> emp4 = new Emp<Integer>("11", "킹세종");		// Integer로 type 강제했기 때문에 불가!
		Emp<Integer> emp4 = new Emp<Integer>(11, "킹세종");
		System.out.println(emp4.getEname() + ":" + emp4.getEmpno());
	}
}
