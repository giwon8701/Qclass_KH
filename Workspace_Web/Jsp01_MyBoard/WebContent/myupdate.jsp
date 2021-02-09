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
	int myno = Integer.parseInt(request.getParameter("myno"));
	String myname = request.getParameter("myname");
	String mytitle = request.getParameter("mytitle");
	String mycontent= request.getParameter("mycontent");
%>
<body>

	<h1>글 수정</h1>
	
	<!-- 글 작성할 때 post인 이유 : queryString이 허용범위 이상으로 길어지면, request 불가!! -->
	<form action="myupdate_res.jsp" method="post">
			<table border="1">
			<tr>
				<th>작성자</th>
				<td style="display:none;"><input type="text" name="myno" value="<%=myno%>"></td>
				<td><input type="text" name="myname" value="<%=myname%>"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="mytitle" value="<%=mytitle%>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="mycontent"><%=mycontent%></textarea></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="작성">
					<input type="button" value="취소" onclick="location.href='./myselect.jsp?myno=<%=myno%>&myname=<%=myname%>&mytitle=<%=mytitle%>&mycontent=<%=mycontent%>'">
				</td>
			</tr>
			</table>
	</form>

</body>
</html>