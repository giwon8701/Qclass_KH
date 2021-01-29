package com.test01;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class MTest02 {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://iei.or.kr/resources/images/main/20201210_popup_new.jpg");
		
		URLConnection urlConnection = url.openConnection();
		urlConnection.connect();
		
		byte[] b = new byte[1];
		DataInputStream di = new DataInputStream(urlConnection.getInputStream());
		FileOutputStream fo = new FileOutputStream("a.jpg");
		
		while(di.read(b, 0, 1) != -1) {
			fo.write(b, 0, 1);
		}
		
		fo.close();
		di.close();
	}
}
