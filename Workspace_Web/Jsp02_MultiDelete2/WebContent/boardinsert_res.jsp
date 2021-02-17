<%@page import="com.mdboard.dao.MDBoardDaoImpl"%>
<%@page import="com.mdboard.dao.MDBoardDao"%>
<%@page import="com.muldel.dto.MDBoardDto"%>
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
	
	MDBoardDto dto = new MDBoardDto();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	
	MDBoardDao dao = new MDBoardDaoImpl();
	
	int res = dao.insert(dto);
	
	if (res > 0) {
%>
		<script type="text/javascript">
			location.href="./boardlist.jsp";
		</script>
<%
	} else {
%>
		<script type="text/javascript">
			alert("글이 작성되지 않았습니다. 글자수를 확인해주세요.");
			location.href="./boardinsert.jsp";
		</script>	
<%		
	}
%>
<body>

</body>
</html>