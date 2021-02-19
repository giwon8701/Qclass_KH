<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
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
	int seq = Integer.parseInt(request.getParameter("seq"));
	MVCBoardBiz biz = new MVCBoardBizImpl();
	MVCBoardDto dto = biz.selectOne(seq);
%>
	<script type="text/javascript">
		function deleteProc(seq) {
			if (confirm("정말 삭제하시겠습니까?") == true) {
				location.href = "./mycontroller.jsp?command=delete&seq=<%=seq%>";
			}
		}
	</script>
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
				<input type="button" value="수정" onclick="location.href='./mycontroller.jsp?command=updateform&seq=<%=dto.getSeq()%>'">
				<input type="button" value="삭제" onclick="deleteProc(<%=dto.getSeq()%>);">
				<input type="button" value="목록" onclick="location.href='./mycontroller.jsp?command=list'">
			</td>
		</tr>
	</table>

</body>
</html>