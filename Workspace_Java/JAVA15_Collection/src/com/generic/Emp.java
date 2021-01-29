package com.generic;

// generic : 개발자가 의도한 타입만 저장할 수 있도록 함. (타입 강제)
public class Emp<T> {

	private T empno;
	private String ename;
	
	public Emp() {
		
	}
	public Emp(T empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}
	
	public T getEmpno() {
		return empno;
	}
	public void setEmpno(T empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	
}
