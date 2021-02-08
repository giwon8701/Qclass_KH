<%@page import.java.sql.Connection'%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%


	// scriptlet : 여기가 자바 코드 영역이다.
	
	// EMP 테이블 전체 출력
	
	// 1. driver 연결
	Class.forName("orecle.jdbc.driver.OracleDriver");
	
	// 2. 계정 연결
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "kh";
	String password = null;
	
	con = DriverManager.getConnection(url, user, password);
	
	// 3. query 준비
	String sql = " SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO " +
				 " FROM EMP ";
	
	Statement stmt = null;
	ResultSet rs = null;
	
	stmt = con.createStatement;
	
%>
</body>
</html>
