<%@page import="java.util.List"%>
<%@page import="com.board.dto.MyBoardDto"%>
<%@page import="com.board.dao.MyBoardDao"%>
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
	MyBoardDao dao = new MyBoardDao();
	List<MyBoardDto> list = dao.selectList();
%>
<body>

	<table border="1">
	<col width="100px">
	<col width="150px">
	<col width="300px">
	<col width="100px">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (MyBoardDto dto : list) {
			%>
				<tr>
					<td><%=dto.getSeq()%></td>
					<td><%=dto.getWriter()%></td>
					<td><a href="./selectOne.jsp?seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
					<td><%=dto.getRegdate()%></td>
				</tr>
			<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4" align="right">
				<button onclick="location.href='./insert.jsp'">글쓰기</button>
				</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>