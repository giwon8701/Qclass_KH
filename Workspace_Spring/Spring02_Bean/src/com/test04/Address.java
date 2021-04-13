package com.test04;

public class Address {

	private String name;
	private String addr;
	private String phone;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddr() {
		return addr;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	
	@Override
	public String toString() {
		return "이름: " + name + " \t 주소 : " + addr + " \t 전화번호 : " + phone;
	}
}
