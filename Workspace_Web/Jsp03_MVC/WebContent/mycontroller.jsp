<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
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

<%
	String command = request.getParameter("command");
	System.out.printf("[%s]\n", command);
	
	MVCBoardBiz biz = new MVCBoardBizImpl();

	// 요청한 명령을 받는다.
	if (command.equals("list")) {
		// 1. 보내준 값이 있으면, 받는다.
		
		// 2. db에 전달할 값이 있으면 전달하고,
		//	  없으면 없는대로 호출해서 리턴받는다.
		List<MVCBoardDto> list = biz.selectList();
		
		// 3. 화면에 전달할 값이 있으면, request 객체에 담아준다.
		request.setAttribute("list", list);
		
		// 4. 보낸다.
		// pageContext.forward() : 페이지 위임 (request, response 객체가 그대로 전달)
		pageContext.forward("mylist.jsp");
	} else if (command.equals("insertform")) {
		// 1. 보내준 값이 있으면, 받는다.
		// 2. db에 전달할 값이 있으면 전달하고,
		//	  없으면 없는대로 호출해서 리턴받는다.
		// 3. 화면에 전달할 값이 있으면, request 객체에 담아준다.
		// 4. 보낸다. 보낼것이 없으면 아래처럼 화면전환해준다.
		// response.sendRedirect() : 페이지 이동 (새로운 request, response 객체)
		response.sendRedirect("myinsert.jsp");
	} else if (command.equals("insertres")) {
		// 1.
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 2.
		MVCBoardDto dto = new MVCBoardDto(writer, title, content);
		int res = biz.insert(dto);
		
		// 3.
		// 4.
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("글 작성 성공")
			location.href='mycontroller.jsp?command=list';
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("글 작성 실패");
			location.href='mycontroller.jsp?command=insertform';
		</script>
<%
		}
	}
%>
			
		}
	}
%>


</body>
</html>