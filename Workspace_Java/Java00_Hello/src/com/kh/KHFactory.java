package com.kh;

public class KHFactory {

	public static void main(String[] args) {
		System.out.println("============KH Factory 생산 시작===========");
		Product[] kh = new Product[5];
		
		kh[0] = new Computer(1, "KH컴퓨터", 123456);
	}
}
