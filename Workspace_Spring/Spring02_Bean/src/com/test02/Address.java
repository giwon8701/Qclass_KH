package com.test02;

public class Address {

	private String name;
	private String addr;
	private String phone;
	public Address() {	
	}
	public Address(String name, String addr, String phone) {
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Address [name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}
}
