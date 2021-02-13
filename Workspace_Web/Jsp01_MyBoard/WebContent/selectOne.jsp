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
	int seq = Integer.parseInt(request.getParameter("seq"));
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectOne(seq);
%>
<body>
	<h1>글 자세히 보기</h1>

	<table border="1">
	<col width="100px">
	<col width="300px">
		<tr>
			<th>작성자</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr style="height:300px;">
			<th>내용</th>
			<td><%=dto.getContent() %></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="수정" onclick="location.href='./update.jsp?seq=<%=dto.getSeq()%>'">
				<input type="button" value="삭제" onclick="load_delete();">
				<input type="button" value="목록" onclick="location.href='./selectList.jsp'">
			</td>
		</tr>
	</table>
	
	<script type="text/javascript">
		function load_delete() {
			if (confirm("정말 삭제하시겠습니까?") == true) {
				location.href = "./delete.jsp?seq=<%=seq%>";
			}
		}
	</script>
</body>
</html>