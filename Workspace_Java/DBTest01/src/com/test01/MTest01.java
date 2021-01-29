package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MTest01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ojbdc6.jar (꼭! 추가해야한다!!)-> oracle.jdbc.driver.OracleDriver
		// 1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		// 3. QUERY 준비
		String sql = " SELECT * FROM EMP ";
		Statement stmt = con.createStatement();
		
		// 4. QUERY 실행 및 리턴
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.printf("%5d %11s %9s %5d %10s %8.2f %8.2f %2d \n",
					rs.getInt(1), rs.getString(2), rs.getString("JOB"), rs.getInt(4),
					rs.getDate(5), rs.getDouble("SAL"), rs.getDouble(7), rs.getInt(8));
		}
		
		// 5. DB 종료
		rs.close();
		stmt.close();
		con.close();
	}
}
