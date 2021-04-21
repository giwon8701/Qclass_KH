<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>연습</h1>
	
	<a href="home">home...</a>
	<br>
	<a href="command.do?name=spring&addr=서울&phone=010-1234-5678">get</a>
	<br>
	<form action="command.do" method="post">
		이름:<input type="text" name="name"/><br>
		주소:<input type="text" name="addr"/><br>
		번호:<input type="text" name="phone"/><br>
		<input type="submit" value="전송"/>
	</form>
	<a href="void.do">void</a>

</body>
</html>