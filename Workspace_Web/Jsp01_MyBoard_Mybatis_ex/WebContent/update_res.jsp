<%@page import="com.board.dto.MyBoardDto"%>
<%@page import="com.board.dao.MyBoardDao_old"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
%>
<body>
	
	<%
			MyBoardDao_old dao = new MyBoardDao_old();
				MyBoardDto dto = new MyBoardDto();
				dto.setTitle(title);
				dto.setContent(content);
				dto.setSeq(seq);
				
				int res = dao.update(dto);
				if (res > 0) {
		%>
		<script type="text/javascript">
			alert("수정 성공!");
			location.href="./selectOne.jsp?seq=<%=seq%>";
		</script>
	<%
		} else {
	%>
		<script>
			alert("수정 실패!");
		</script>
	<%
		}
	%>
	
</body>
</html>