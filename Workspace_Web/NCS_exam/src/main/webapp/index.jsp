<%@page import="com.ncs.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello Spring!</h1>
<form action="LoginController" method="get">
<c:choose>

	<c:when test="${not empty sessionScope.member}">	
		<input type="hidden" name="command" value="logout">
		<c:out value="${sessionScope.member }"/>
		<br>
		<br>
		<input type="submit" value="로그아웃하기">
	</c:when>
	
	<c:otherwise>
		<input type="hidden" name="command" value="login">
		userId : <input type="text" name="userId">
		<br>
		password : <input type="password" name="password">
		<br>
		<br>
		<input type="submit" value="로그인하기">
	</c:otherwise>
	
</c:choose>
</form>
</body>
</html>