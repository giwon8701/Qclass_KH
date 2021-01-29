package com.test01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MTest04 {

	public static void main(String[] args) throws IOException {
		File fi = new File("b.txt");

			MyOutput(fi);
			MyInput(fi);
	}

	// read
	private static void MyInput(File fi) throws IOException {
		FileReader fr = new FileReader(fi);
		int ch;
		while ((ch = fr.read()) != -1) {
			System.out.println(ch);
		}
		fr.close();
	}

	// write
	private static void MyOutput(File fi) throws IOException {
		FileWriter fw = new FileWriter(fi, false);

		fw.write("연습중입니다.\n");
		fw.append("abc\t").append("def");

		fw.close();
	}
}
