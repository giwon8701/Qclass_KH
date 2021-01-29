package com.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient implements Runnable {

	@Override
	public void run() {
		try {

			Socket clientSocket;
			PrintWriter out = null;
			BufferedReader in = null;
			BufferedReader stdin = null;

			System.out.println("server에 접속합니다....");
			clientSocket = new Socket("localhost", 9999);
			
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			stdin = new BufferedReader(new InputStreamReader(System.in));
			
			String inputLine;
			while((inputLine = stdin.readLine()) != null) {
				out.println(inputLine);
				System.out.println("server: " + in.readLine());
			}
			
			stdin.close();
			in.close();
			out.close();
			clientSocket.close();

		} catch (IOException e) {

		}
	}

	public static void main(String[] args) {
		Thread client = new Thread(new MyClient());
		client.start();
	}

}
