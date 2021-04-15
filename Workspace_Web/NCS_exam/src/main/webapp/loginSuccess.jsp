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
<h1>Hello Spring!</h1>
<h3>로그인 성공!!</h3>

<script type="text/javascript">
	setTimeout(function() {
		location.href="index.jsp";
	}, 1500);
</script>
</body>
</html>