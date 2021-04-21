<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>이름</th>
			<td>${dto.name }
		</tr>
		<tr>
			<th>주소</th>
			<td>${dto.addr }
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${dto.phone }
		</tr>
	</table>

</body>
</html>