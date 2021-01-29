package com.test01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MTest03 {

	public static void main(String[] args) {

		File fi = new File("a.txt");

		try {
			MyOutput(fi);
			MyInput(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void MyInput(File fi) throws IOException {
		FileInputStream fin = new FileInputStream(fi);
		int res = 0;

		// file의 내용 끝 = -1
		while ((res = fin.read()) != -1) {
			System.out.println((char) res);
		}

		fin.close();
	}

	// throws : 해당 메소드 내부에서 발생할 수 있는 예외를, 메소드 호출하는 곳으로 위임
	private static void MyOutput(File fi) throws IOException {
		FileOutputStream fo = new FileOutputStream(fi);

		for (int i = 65; i < 91; i++) {
			fo.write(i);
		}

		// 반드시!!!
		fo.close();
	}
}
