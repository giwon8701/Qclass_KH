<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.muldel.biz.MDBoardBizImpl"%>
<%@page import="com.muldel.biz.MDBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		// muldelform이라는 id를 가진 태그(form 태그)에서 submit 이벤트가 발생 시
		$("#muldelform").submit(function() {
			// 유효성 검사
			if ($("#muldelform input:checked").length == 0) {
				alert("하나 이상 체크해 주세요");
				return false;
			}
		});
	});
	function allCheck(bool) {
		var chks = document.getElementsByName("chk");
		for (var i=0; i<chks.length; i++) {
			chks[i].checked = bool;
		}
	}
</script>
</head>
<%
	MDBoardBiz biz = new MDBoardBizImpl();
	List<MDBoardDto> list = biz.selectList();
%>
<body>

	<h1>list</h1>
	
	<form action="./muldel.jsp" method="post" id="muldelform">
		<table border="1">
			<col width="30px">
			<col width="50px">
			<col width="100px">
			<col width="500px">
			<col width="100px">
	<tr>
		<th><input type="checkbox" name="all" onclick="allCheck(this.checked);"></th>
		<th>번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>작성일</th>
	</tr>
	
<%
	if (list.size() == 0) {
%>
		<tr>
			<td colspan="5">--------------작성된 글이 존재하지 않습니다-------------</td>
		</tr>
<%
	} else {
		for(MDBoardDto dto : list) {
%>
			<tr>
				<th><input type="checkbox" name="chk" value="<%=dto.getSeq() %>"></th>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getWriter() %></td>
				<td><a href="./boardselect.jsp?seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
				<td><%=dto.getRegDate() %></td>
			</tr>
<%	
		}
	}
%>
			<tr>
				<td colspan="5" align="right">
					<input type="submit" value="선택삭제">
					<input type="button" onclick="location.href='./boardinsert.jsp'" value="글작성">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>