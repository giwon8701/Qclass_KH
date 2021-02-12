<%@page import="com.board.dao.MyBoardDao"%>
<%@page import="com.board.dto.MyBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	MyBoardDto dto = new MyBoardDto();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	
	MyBoardDao dao = new MyBoardDao();
	
	int res = dao.insert(dto);
	
	if (res > 0) {
%>
		<script type="text/javascript">
		alert("글이 작성되었습니다!");
		location.href="./selectList.jsp";
		</script>
<%
	} else {
%>
		<script type="text/javascript">
			alert("글이 작성되지 않았습니다..");
			location.href="./insert.jsp";
		</script>	
<%		
	}
%>
<body>

</body>
</html>