<%@page import="com.login.dto.MYMemberDto"%>
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
<%
	MYMemberDto dto = (MYMemberDto)session.getAttribute("dto");
%>
<body>

	<div>
		<span><%=dto.getMyid() %>님 환영합니다.</span>
		<a href="">logout</a>
	</div>
	
	<div>
		<div>
			<a href="">회원 전체 조회(탈퇴한 회원 포함)</a>
		</div>
		<div>
			<a href="">회원 전체 조회(MYENABLED=Y)</a>
		</div>
	
	</div>

</body>
</html>