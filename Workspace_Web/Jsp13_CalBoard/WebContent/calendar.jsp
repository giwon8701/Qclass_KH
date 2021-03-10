<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	
	#calendar {
		border-collapse: collapse;
		border: 1px solid gray;
	}
	#calendar th {
		width: 80px;
		border: 1px solid gray;
	}
	#calendar td {
		width: 80px;
		height: 80px;
		border: 1px solid gray;
		text-align: left;
		vertical-align: top;
		position: relative;
	}
</style>
</head>
<body>

	<table id="calendar">
		<caption>
			<a href="">◁</a>
			<a href="">◀</a>
			
			<span class=""></span>년
			<span class=""></span>월
			
			<a href="">▶</a>
			<a href="">▷</a>
		</caption>
		
		<tr>
			<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
		</tr>
	</table>

</body>
</html>