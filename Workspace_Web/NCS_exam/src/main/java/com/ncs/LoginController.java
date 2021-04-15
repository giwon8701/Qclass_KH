package com.ncs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService service = new LoginService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		Member m = new Member();	// 로그인으로 입력된 유저 정보
		HttpSession session = request.getSession();
		
		if (command.equals("login")) {
			m.setUserId(userId);
			m.setPassword(password);
			Member member = service.selectOneMember(m);	// 로그인결과로 가져온 유저정보
			
			if (member != null) {	// 로그인 성공
				session.setAttribute("member", member);
				System.out.println(member.getUserName());
				response.sendRedirect("loginSuccess.jsp");
			} else {	// 로그인 실패
				response.sendRedirect("loginFail.jsp");
			}
			
		} else if (command.equals("logout")) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
