<%@page import="sun.font.Script"%>
<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
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
<body>

<%
	String command = request.getParameter("command");
	System.out.printf("[%s]\n", command);
	
	MVCBoardBiz biz = new MVCBoardBizImpl();
	
	// 요청한 명령을 확인한다.
	if(command.equals("list")){
		// 1. 보내준 값이 있으면 받는다.
		// 2. db에 전달할 값이 있으면 전달하고
		//    없으면 없는대로 호출해서 리턴받는다.
		List<MVCBoardDto> list = biz.selectList();
		
		// 3. 화면에 전달할 값이 있으면 request 객체에 담아준다 (obj타입으로 감싸져 담아짐)
		request.setAttribute("list", list);
		
		// 4. 보낸다.
		pageContext.forward("mylist.jsp");
		
	} else if(command.equals("insertform")){	// list서 db에 전달할 값이나 화면에 전달할 값이나뭐 이런게 없으면 1, 2, 3, 4 가 없는거
		// 1.
		// 2.
		// 3.
		// 4.
		response.sendRedirect("myinsert.jsp");
		/*
			pageContext.forward() : 페이지 위임 (request, response 객체 그대로 전달)
			response.sendRedirect() : 페이지 이동 (새로운 request, response 객체)	근데 이경우 세션은 유지 되나? 세션이 애초에 별개의 임시공간으로 생각했는데 맞나?
		*/
	} else if(command.equals("insertres")){
		// 1.
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 2.
		MVCBoardDto dto = new MVCBoardDto(0, writer, title, content, null);

		int res = biz.insert(dto);
		// 3.
		// 4.
		if(res > 0){
%>
		<script type="text/javascript">
			alert("글 작성 성공");
			location.href='mycontroller.jsp?command=list';	// 여부분
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
	} else if(command.equals("selectform")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		MVCBoardDto res = biz.selectOne(seq);
		
		request.setAttribute("seq", res);
		
		pageContext.forward("myselect.jsp");
		
	} else if(command.equals("delete")){
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		int res = biz.delete(seq);
		
		if(res > 0){
%>		
			<script type="text/javascript">
				alert("삭제 성공");
				location.href="mycontroller.jsp?command=list";
			</script>
<%
		} else {
%>
			<script type="text/javascript">
				alert("삭제 실패");
				location.href="mycontroller.jsp?command=selectform&seq=<%=seq%>";
			</script>
<%
		}
	} else if(command.equals("update")){
		// 1
		int seq = Integer.parseInt(request.getParameter("seq"));
		// 2
		MVCBoardDto dto = biz.selectOne(seq);
		// 3
		request.setAttribute("dto", dto);
		// 4
		pageContext.forward("myupdate.jsp");
		
	} else if(command.equals("updateres")){
		// 1
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 2
		MVCBoardDto dto = new MVCBoardDto();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = biz.update(dto);
		// 3
		// 4
		if(res > 0){
%>			
		<script type="text/javascript">
			alert("수정 성공");
			location.href="mycontroller.jsp?command=selectform&seq=<%=seq%>";		
		</script>		
<%			
		} else {
%>			
		<script type="text/javascript">
			alert("수정 실패");
			history.back();
		</script>
<%			
		}
	}
%>
	

</body>
</html>