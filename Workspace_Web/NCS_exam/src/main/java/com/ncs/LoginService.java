package com.ncs;

import static com.ncs.JDBCTemplate.*;

import java.sql.Connection;

public class LoginService {

	private LoginDAO dao = new LoginDAO();
	
	public Member selectOneMember(Member m) {
		Connection conn = getConnection();
		Member member = dao.selectOneMember(conn, m);
		
		return member;
	}
}
