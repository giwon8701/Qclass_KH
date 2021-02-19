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
	if (command.equals("list")) {					// selectList  !!!!!!!!!!!!!!
		// 1. 보내준 값이 있으면, 받는다.
		
		// 2. db에 전달할 값이 있으면 전달하고,
		//	  없으면 없는대로 호출해서 리턴받는다.
		List<MVCBoardDto> list = biz.selectList();
		
		// 3. 화면에 전달할 값이 있으면, request 객체에 담아준다.
		request.setAttribute("list", list);
		
		// 4. 보낸다.
		// pageContext.forward() : 페이지 위임 (request, response 객체가 그대로 전달)
		pageContext.forward("mylist.jsp");
	} else if (command.equals("selectone")) {
		// 1.
		int seq = Integer.parseInt(request.getParameter("seq"));
		// 2.
		MVCBoardDto dto = new MVCBoardDto();
		dto.setSeq(seq);
		// 3.
		request.setAttribute("seq", seq);
		
		// 4.
		pageContext.forward("myselect.jsp");
		
	} else if (command.equals("insertform")) {		// insert !!!!!!!!!!!!!!
		// 1. 보내준 값이 있으면, 받는다.
		// 2. db에 전달할 값이 있으면 전달하고,
		//	  없으면 없는대로 호출해서 리턴받는다.
		// 3. 화면에 전달할 값이 있으면, request 객체에 담아준다.
		// 4. 보낸다. 보낼것이 없으면 아래처럼 화면전환해준다.
		// response.sendRedirect() : 페이지 이동 (새로운 request, response 객체)
		response.sendRedirect("myinsert.jsp");
	} else if (command.equals("insertres")) {		// insertres !!!!!!!!!!!!!!
		// 1.
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 2.
		MVCBoardDto dto = new MVCBoardDto(writer, title, content);
		int res = biz.insert(dto);
		System.out.println("res: "+res);
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
	} else if (command.equals("updateform")) {
		// 1.
		int seq = Integer.parseInt(request.getParameter("seq"));
		//pageContext.forward("myselect.jsp?seq="+dto.getSeq());
		// 2.
		MVCBoardDto dto = biz.selectOne(seq);
		System.out.println("dto : " + dto.getSeq());
		// 3.
		request.setAttribute("dto", dto);
		// 4.
		pageContext.forward("myupdate.jsp");
	} else if (command.equals("updateres")) {
		// 1.
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 2.
		MVCBoardDto dto = new MVCBoardDto();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		int res = biz.update(dto);
		// 3.
		// 4.
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("수정 성공");
			location.href="mycontroller.jsp?command=selectone&seq=<%=seq%>";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("수정 실패");
			history.back(); // 뒤로가기
		</script>
<%
		}
	} else if (command.equals("delete")) {
		// 1.
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		// 2.
		int res = biz.delete(seq);
		
		// 3.
		// 4.
		if (res > 0) {
%>
		<script type="text/javascript">
			alert("삭제되었습니다!");
			location.href="./mycontroller.jsp?command=list";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("삭제에 실패하였습니다!");
			location.href="./mycontroller.jsp?command=selectone&seq=<%=seq%>";
		</script>
<%
		}
	}
%>	

</body>
</html>