<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
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
	// request는 받아오는 타입을 모른다 Object로 받는다(최상위 타입) 그래서 부모타입에서 자식타입으로 가기에 (명시적) 형변환 해줘야함
	List<MVCBoardDto> list = (List<MVCBoardDto>) request.getAttribute("list");
%>
<body>

	<h1>List</h1>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		
<%
		for(MVCBoardDto dto : list){
%>
		<tr>
			<td><%=dto.getSeq() %></td>
			<td><%=dto.getWriter() %></td>
			<td><a href="myservlet.do?command=selectone&seq=<%=dto.getSeq() %>"><%=dto.getTitle() %></a></td>
			<td><%=dto.getRegdate() %></td>
		</tr>
<%
		}
%>		

		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글작성" onclick="location.href='myservlet.do?command=insertform'">
			</td>
		</tr>
	</table>

</body>
</html>