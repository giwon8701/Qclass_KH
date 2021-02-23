<%@page import="java.util.List"%>
<%@page import="com.login.dto.MYMemberDto"%>
<%@page import="com.login.biz.MYMemberBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command = request.getParameter("command");
	System.out.println("[" + command + "]");
	
	MYMemberBiz biz = new MYMemberBiz();
	
	if (command.equals("login")) {
		
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		
		MYMemberDto dto = biz.login(myid, mypw);
		
		if (dto != null) {
			// seession scope에 객체 담기
			session.setAttribute("dto", dto);
			// 만료되는 시간 설정 (default: 30분)
			session.setMaxInactiveInterval(10 * 60);
			if (dto.getMyenabled().equals("Y")) {
				if (dto.getMyrole().equals("ADMIN")) {
					response.sendRedirect("adminmain.jsp");
				} else if (dto.getMyrole().equals("USER")) {
					response.sendRedirect("usermain.jsp");
				}
			} else {
%>
				<script type="text/javascript">
					alert("탈퇴한 회원입니다.");
					location.href="index.html";
				</script>
<%
			}
			
		} else {
%>
		<script type="text/javascript">
			alert("로그인 실패");
			location.href="index.html";
		</script>

<%		
		}
		
	} else if (command.equals("logout")) {
		// session scope에서 값 삭제 (만료)
		session.invalidate();
		response.sendRedirect("index.html");
		
	} else if (command.equals("listall")) {
		List<MYMemberDto> list = biz.selectAlluser();
		request.setAttribute("list", list);
		pageContext.forward("userlistall.jsp");
		
	} else if (command.equals("listen")) {
		List<MYMemberDto> list = biz.selectEnabledUser();
		request.setAttribute("list", list);
		pageContext.forward("userlisten.jsp");
		
	} else if (command.equals("updateroleform")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		MYMemberDto dto = biz.selectUser(myno);
		request.setAttribute("dto", dto);
		pageContext.forward("updaterole.jsp");
		
	} else if (command.equals("updaterole")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("myrole");
		
		int res = biz.updateRole(myno, myrole);
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("등급 변경 성공");
			location.href="logincontroller.jsp?command=listen";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("등급 변경 실패");
			location.href="logincontroller.jsp?command=updateroleform&myno=<%=myno%>";
		</script>
<%
		}
	} else if (command.equals("registform")) {
		response.sendRedirect("regist.jsp");
		
	} else if (command.equals("idchk")) {
		String myid = request.getParameter("myid");
		MYMemberDto dto = biz.idCheck(myid);
		boolean idnotused = true;
		
		if (dto.getMyid() != null) {
			idnotused = false;
		}
		
		response.sendRedirect("idchk.jsp?idnotused="+idnotused);
	} else if (command.equals("regist")) {
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		MYMemberDto dto = new MYMemberDto();
		dto.setMyid(myid);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
		
		int res = biz.insertUser(dto);
		if (res > 0) {
%>
			<script type="text/javascript">
				alert("가입 성공하였습니다!");
				location.href="index.html";
			</script>
<%
		} else {
%>
			<script type="text/javascript">
				alert("가입 실패하였습니다!");
			</script>
<%			
		}
		
	} else if (command.equals("adminmain")) {
		response.sendRedirect("adminmain.jsp");
	} else if (command.equals("delete")) {
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		int res = biz.deleteUser(myno);
		
		if (res > 0) {
%>
			<script>
				alert("삭제 성공");
				location.href="logincontroller.jsp?command=listen";
			</script>
<%
		} else {
%>
			<script>
				alert("삭제 실패");
			</script>
<%
		}
	}
%>
</body>
</html>