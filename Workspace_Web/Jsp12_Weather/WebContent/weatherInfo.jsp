<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%-- 예외를 throws 해줌 --%>
<c:catch var="err">
	<%-- c:set을 통해서 url값을 변수로 편하게 쓸 수 있게 만들어준다. --%>
	<c:set var="weatherURL" value="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=${code}" />
	<%-- import를 이용하여 url페이지의 데이터을 가져옴 --%>
	<c:import var="weather" url="${weatherURL}" />
	<%-- 위에서 가져온 데이터를 파싱해줌 --%>
	<x:parse var="wrss" xml="${weather}" />
{ 
"pubDate":"<x:out select="$wrss/rss/channel/pubDate" />",
"temp":"<x:out select="$wrss/rss/channel/item/description/body/data/temp" />",
"reh":"<x:out select="$wrss/rss/channel/item/description/body/data/reh" />",
"pop":"<x:out select="$wrss/rss/channel/item/description/body/data/pop" />",
"x":"<x:out select="$wrss/rss/channel/item/description/header/x" />",
"y":"<x:out select="$wrss/rss/channel/item/description/header/y" />",
"wfKor":"<x:out select="$wrss/rss/channel/item/description/body/data/wfKor" />"
}
</c:catch>
<c:if test="${err!=null}">
	${err}
</c:if>
