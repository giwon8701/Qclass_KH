<%@page import="com.muldel.dao.MDBoardDaoImpl"%>
<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="com.muldel.dao.MDBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	MDBoardDao dao = new MDBoardDaoImpl();
	MDBoardDto dto = dao.selectOne(seq);
%>
<body>
	<h1>글 수정 페이지</h1>
	<form action="boardupdate_res.jsp" method="post">
		<input type="hidden" name="seq" value="<%=seq%>">
		<table border="1">
			<col width="100px">
			<col width="300px">
			<tr>
				<th>작성자</th>
				<td><%=dto.getWriter()%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="<%=dto.getTitle()%>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="40" name="content"><%=dto.getContent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정">
					<input type="button" value="취소" onclick="location.href='./boardselect.jsp?seq=<%=seq%>'">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>