<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	MVCBoardDto dto = (MVCBoardDto) request.getAttribute("dto");
%>
<body>

	<h1>Update</h1>
	
	<form action="mycontroller.jsp" method="post"> <!-- 값을 여러개 보낼 때 form태그 이용 -->
		<input type="hidden" name="command" value="updateres">
		<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><%=dto.getWriter() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" vlaue="<%=dto.getTitle()%>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="content"><%=dto.getContent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정">
					<input type="button" value="취소" onclick="location.href='mycontroller.jsp?command=selectform&seq=<%=dto.getSeq()%>'">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>