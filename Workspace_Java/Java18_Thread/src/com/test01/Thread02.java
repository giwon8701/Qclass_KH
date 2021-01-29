package com.test01;

class MyThread02 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
}

public class Thread02 {
	
	public static void main(String[] args) {
		MyThread02 my01 = new MyThread02();
		MyThread02 my02 = new MyThread02();
		
		// start() -> run()을 자동 호출
		my01.start();
		my02.start();
	}

}
