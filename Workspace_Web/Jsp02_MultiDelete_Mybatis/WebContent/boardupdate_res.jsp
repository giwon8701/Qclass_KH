<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="com.muldel.biz.MDBoardBizImpl"%>
<%@page import="com.muldel.biz.MDBoardBiz"%>
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
	String title = request.getParameter("title");
	String content = request.getParameter("content");
%>
<body>
	<%
		MDBoardBiz dao = new MDBoardBizImpl();
		MDBoardDto dto = new MDBoardDto();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setSeq(seq);
		
		int res = dao.update(dto);
		if (res > 0) {
			
	%>
		<script type="text/javascript">
			alert("수정 성공!");
			location.href="./boardselect.jsp?seq=<%=seq%>";
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