<%@page import="com.cal.dao.CalDao"%>
<%@page import="com.cal.dto.CalDto"%>
<%@page import="java.util.List"%>
<%@page import="com.cal.common.Util"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	
	#calendar {
		border-collapse: collapse;
		border: 1px solid gray;
	}
	#calendar th {
		width: 80px;
		border: 1px solid gray;
	}
	#calendar td {
		width: 80px;
		height: 80px;
		border: 1px solid gray;
		text-align: left;
		vertical-align: top;
		position: relative;
	}
	a {
		text-decoration: none;
	}
	
	.list > p {
		font-size: 5px;
		margin: 1px;
		background-color: skyblue;
	}
	
	.preview {
		position: absolute;
		top: -30px;
		left: 10px;
		background-color: skyblue;
		width: 40px;
		height: 40px;
		text-align: center;
		line-height: 40px;
		border-radius: 40px 40px 40px 1px;
	}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
	function isTwo(n) {
		return (n.length<2)? "0"+n : n;
	}

	$(function() {
		$(".countView").hover(function() {
			// handle in
			var countView = $(this);
			var year = $(".y").text().trim();
			var month = $(".m").text().trim();
			var date = countView.text().trim();
			var yyyyMMdd = year + isTwo(month) + isTwo(date);
			
			$.ajax({
				type: "post",
				url: "count.do?id=kh&yyyyMMdd="+yyyyMMdd,
				dataType: "json",
				async: false,
				success: function(msg) {
					var count = msg.calcount;
					countView.after("<div class='preview'>" + count + "</div>");
				},
				error: function() {
					alert("통신 실패");
				}
			});
		},
		function() {
			// handle out
			$(".preview").remove();
			
			
		});
	});
</script>

</head>
<body>
<%
	// 현재날짜와 시간으로 설정된다.
	Calendar cal = Calendar.getInstance();

	// year, month의 default값은 현재날짜
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH) + 1;	// Calendar.MONTH -> 1월은 0부터 시작하므로 우리가 보기 편하게 하려면 +1 해줘야함
	String paramYear = request.getParameter("year");
	String paramMonth = request.getParameter("month");
	// paramYear,paramMonth에 값이 담겨있으면 year,month에 넣어줌
	if (paramYear != null) {
		year = Integer.parseInt(paramYear);
	}
	if (paramMonth != null) {
		month = Integer.parseInt(paramMonth);
	}
	
	if (month > 12) {
		month = 1;
		year++;
	}
	if (month < 1) {
		month = 12;
		year--;
	}

	// 위에서 설정한 year와 month (업데이트 될때마다 설정한 년,월,1일이 default로 잡힘)
	cal.set(year, month-1, 1);	// 계산한 값을 다시 Calendar에 넣어야하니 month-1해줌(1월은 0부터 시작하므로)

	// date를 위에서 1로 set했기 때문에, DAY_OF_WEEK는 해당월의 1일의 요일을 가리킴
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);	// Calendar.get()에 DAY_OF_WEEK를 넣으면 -> 일요일이면 1, 월요일이면 2, ....를 반환함
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);	// 해당 월의 마지막day를 출력함  -> 일요일이면 1, 월요일이면 2, ....를 반환함
	
	CalDao dao = new CalDao();
	String yyyyMM = year + Util.isTwo(String.valueOf(month));
	List<CalDto> list = dao.getCalViewList("kh", yyyyMM);
%>
	<table id="calendar">
		<caption>
			<a href="calendar.jsp?year=<%=year-1%>&month=<%=month%>">◁</a>
			<a href="calendar.jsp?year=<%=year%>&month=<%=month-1%>">◀</a>
			
			<span class="y"><%=year %></span>년
			<span class="m"><%=month %></span>월
			
			<a href="calendar.jsp?year=<%=year%>&month=<%=month+1%>">▶</a>
			<a href="calendar.jsp?year=<%=year+1%>&month=<%=month%>">▷</a>
		</caption>
		
		<tr>
			<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
		</tr>
		
		<tr>
<%
		// dayOfWeek-1 : 1일이 되기 전까지의 빈칸
		for (int i=0; i < dayOfWeek-1; i++) {
			out.print("<td></td>");
		}
		for (int i=1; i<=lastDay; i++) {
%>
			<td>
				<a class="countView" href="cal.do?command=list&year=<%=year %>&month=<%=month %>&date=<%=i %>" style="color: <%=Util.fontColor(i, dayOfWeek)%>"><%=i %></a>	<%--  Util.fontColor가 static method이므로 사용가능 --%>
				<a href="insert.jsp?year=<%=year%>&month=<%=month%>&date=<%=i%>&lastDay=<%=lastDay%>">
					<img alt="" src="image/pen.png" style="width:10px; height: 10px;">
				</a>
				<div class="list">
					<%=Util.getCalView(i, list) %>
				</div>
			</td>
<%
			// (1일되기전 빈칸 + 지금까지 채운 숫자)가 7로 나누어떨어지면 -> 토요일이라는 뜻이므로 다음 줄로 이동
			if ((dayOfWeek-1+i)%7 == 0) {
				out.println("</tr>");
				out.println("<tr>");
			}
		}
		// (dayOfWeek-1 + lastDay)%7 -> 마지막 week의 일수
		// (7 - 마지막 week의 일수) -> 마지막 week의 빈칸 수
		// 마지막week의 일수가 0일경우 : 마지막week의 빈칸 수= 7-0 = 7이 되므로 빈칸이 7개가 생겨버린다.
		// 그래서 %7을 한번 더 해줌으로써 7보다 작으면 그 수가 그대로 나오고, 7이면 0이 되게 한다.
		for (int i=0; i < (7-(dayOfWeek - 1 + lastDay)%7)%7; i++) {
			out.println("<td>");
			out.print("</td>");
		}
%>
		</tr>
	</table>

</body>
</html>