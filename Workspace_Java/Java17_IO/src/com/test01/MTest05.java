package com.test01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MTest05 {

	public static void main(String[] args) {
		File fi = new File("b.txt");

		MyOutput(fi);
		MyInput(fi);
	}

	private static void MyInput(File fi) {
		// try with resources
		try (FileReader fr = new FileReader(fi)) {
			int ch;
			
			while ((ch = fr.read()) != -1) {
				System.out.print((char)ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void MyOutput(File fi) {
		FileWriter fw = null;

		try {
			fw = new FileWriter(fi, true);
			fw.write("다시 연습니다.");
			fw.append("abc\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
