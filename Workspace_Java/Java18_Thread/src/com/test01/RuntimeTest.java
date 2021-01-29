package com.test01;

import java.io.IOException;

public class RuntimeTest {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		
		try {
			// mac :
			// String[]path = {"/usr/bin/open", "-a", "/Applications/fileName.app"}
			// Process porc = rt.exec(path);
			
			//Process prc = rt.exec("notepad.exe");
			Process prc = rt.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
