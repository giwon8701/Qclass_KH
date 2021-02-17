<%@page import="com.mdboard.dao.MDBoardDao"%>
<%@page import="com.mdboard.dao.MDBoardDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	MDBoardDao dao = new MDBoardDaoImpl();
	int res = dao.delete(seq);
	if (res > 0) {
		
%>
<script type="text/javascript">
	alert("삭제되었습니다!");
	location.href="./boardlist.jsp";
</script>
<%
	} else {
%>
<script type="text/javascript">
	alert("실패하였습니다.");
	location.href="./boardselect.jsp?seq=<%=seq%>";
</script>
<%
	}
%>
</body>
</html>