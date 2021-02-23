<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
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
<body>
<%!
	public static final int PAGENUM_MAX = 5;
	public static final int LISTNUM_MAX = 10;
%>
<%
	List<MVCBoardDto> list = (List<MVCBoardDto>) request.getAttribute("list");
	int cntPage = (int) request.getAttribute("cntpage");
	int currentPage = Integer.parseInt(request.getParameter("clickpage"));	//현재 리스트 위치
	
	int listNum = cntPage / PAGENUM_MAX;
%>

	<h1>List</h1>
	
	<table border="1">
		<colgroup>
			<col width="50px">
			<col width="100px">
			<col width="1000px">
			<col width="100px">	
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
<%
		for (MVCBoardDto dto : list) {
%>		
		<tr>
			<td><%=dto.getSeq() %></td>
			<td><%=dto.getWriter() %></td>
			<td><a href="./myselect.jsp?command=selectone&seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
			<td><%=dto.getRegdate() %></td>
		</tr>
<%
	}
%>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글작성" onclick="location.href='mycontroller.jsp?command=insertform'">
			</td>
		</tr>
	</table>
	
	<ul>
<%
		if (listNum % LISTNUM_MAX != 0){
			listNum += (listNum % LISTNUM_MAX);
		}
		for (int i=0; i<LISTNUM_MAX; i++) {
			if (i+1 == currentPage) {
%>
				<li><%=i+1%></li>
<%
			} else {
%>
				<li><a href="./mycontroller.jsp?command=list&clickpage=<%=i+1%>"><%=i+1%></a></li>
<%
			}
		}
%>
	</ul>
</body>
</html>