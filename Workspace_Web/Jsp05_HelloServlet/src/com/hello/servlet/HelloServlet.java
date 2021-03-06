package com.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml 설정을 annotation으로 간략화
// web.xml에서 @servlet("/servlet-mapping")역할을 하고 있다.
//@WebServlet("/HelloServlet")
@WebServlet("/controller.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String contextParam;
	private String initParam;
	
	public HelloServlet() {
		System.out.println("servlet constructor");
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("테스트!");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servelet init");
		
		contextParam = config.getServletContext().getInitParameter("name");
		initParam = config.getInitParameter("sports");
		System.out.println("context-param : " + contextParam);
		System.out.println("init-param : " + initParam);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get 방식으로 들어옴!");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 1.
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		
		// 2.
		// 3.
		// 4.
		PrintWriter out = response.getWriter();
		out.print("<h1 style='color: red'>Hello Servlet</h1>");
		out.print("<h2>계층구조, lifecycle, url-mapping</h2>");
		out.print("<a href='home.html'>home...</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post 방식으로 들어옴!");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 1.
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		// 2.
		// 3.
		// 4.
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color: blue'>Hello Servelet</h1>");
		out.println("<h2>init - service - doGet/doPost - destroy</h2>");
		out.println("<a href='home.html'>home...</a>");
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet destroy");
	}

}
