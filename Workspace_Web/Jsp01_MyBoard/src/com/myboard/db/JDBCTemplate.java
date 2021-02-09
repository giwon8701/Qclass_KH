package com.myboard.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	// 1, 2
	public static Connection getConnection() {
		// 1
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1.driver ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			System.out.println("2. ���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return con;
	}
	
	public static boolean isConnection(Connection con) {
		boolean valid = true;
		
		try {
			if (con == null || con.isClosed()) {
				valid = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return valid;
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Connection con) {
		if (isConnection(con)) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void commit(Connection con) {
		if (isConnection(con)) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void rollback(Connection con) {
		if (isConnection(con)) {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
