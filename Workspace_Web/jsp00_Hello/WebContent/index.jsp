<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%
	// scriptlet : ���Ⱑ �ڹ� �ڵ� �����̴�.
	
	// EMP ���̺� ��ü ���
	
	// 1. driver ����
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	// 2. ���� ����
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "kh";
	String password = "kh";
	Connection con = null;
	
	con = DriverManager.getConnection(url, user, password);
	
	// 3. query �غ�
	String sql = " SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO " +
				 " FROM EMP ";
	
	Statement stmt = null;
	ResultSet rs = null;
	
	stmt = con.createStatement();
	
	// 4. query ���� �� ����
	rs = stmt.executeQuery(sql);
	
	while(rs.next()) {
%>
<!-- HTML ���� -->
	<tr>
		<td><%=rs.getInt(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getInt(4) %></td>
		<td><%=rs.getDate(5) %></td>
		<td><%=rs.getDouble(6) %></td>
		<td><%=rs.getDouble(7) %></td>
		<td><%=rs.getInt(8) %></td>
	</tr>


<%
		
	}
	
	// 5. db ����
	rs.close();
	stmt.close();
	con.close();
%>


</table>

</body>
</html>