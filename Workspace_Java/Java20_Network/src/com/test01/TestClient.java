package com.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestClient {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket ds = new DatagramSocket();
		System.out.println("클라이언트 입니다.");
		
		byte[] buff = "연습입니다.".getBytes();
		
		DatagramPacket sendP = new DatagramPacket(buff, buff.length, InetAddress.getByName("localhost"), 8888);
		
		ds.send(sendP);
		
		ds.close();
		ds.disconnect();
	}
}
