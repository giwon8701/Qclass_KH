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
		Member m = new Member();	// �α������� �Էµ� ���� ����
		HttpSession session = request.getSession();
		
		if (command.equals("login")) {
			m.setUserId(userId);
			m.setPassword(password);
			Member member = service.selectOneMember(m);	// �α��ΰ���� ������ ��������
			
			if (member != null) {	// �α��� ����
				session.setAttribute("member", member);
				System.out.println(member.getUserName());
				response.sendRedirect("loginSuccess.jsp");
			} else {	// �α��� ����
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
