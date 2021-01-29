package com.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Myserver {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket serviceSocket;
		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
			serverSocket = new ServerSocket(9999);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			System.out.println("client를 기다립니다....");
			
			try {
				serviceSocket = serverSocket.accept();
				System.out.println("client가 접속헀습니다!");
				
				in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
				
				out = new PrintWriter(serviceSocket.getOutputStream(), true);
				
				String inputLine;
				while((inputLine = in.readLine()) != null) {
					System.out.println("clinet : " + inputLine);
					out.println(inputLine);
				}
				
				out.close();
				in.close();
				serviceSocket.close();
				serverSocket.close();
			} catch (IOException e) {
				
			}
		}
	}

}
