package com.test01;

import java.net.URI;
import java.net.URISyntaxException;

public class MTest01 {

	public static void main(String[] args) throws URISyntaxException {
		URI u = new URI("http://localhost:8787/Java19_URI_Web/res.jsp?name=%EC%9E%84%EA%B8%B0%EC%9B%90&addr=%EC%84%9C%EC%9A%B8");
		
		System.out.println(u.getScheme());
		System.out.println(u.getHost());
		System.out.println(u.getPort());
		System.out.println(u.getPath());
		System.out.println(u.getQuery());
	}
}
