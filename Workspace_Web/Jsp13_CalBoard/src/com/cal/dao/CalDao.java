package com.cal.dao;

import static com.cal.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cal.dto.CalDto;

public class CalDao {

	public int insertCalBoard(CalDto dto) {
		Connection con = getConnection();
		String sql = " INSERT INTO CALBOARD "
				   + " VALUES(CALBOARDSEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getId());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			pstm.setString(4, dto.getMdate());
			System.out.println("3. query �غ� : " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("4. query ���� �� ����");
			if (res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db ����");
		}
		
		return res;
	}
	
	public List<CalDto> getCalList(String id, String yyyyMMdd) {
		Connection con = getConnection();
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, MDATE, REGDATE "
				   + " FROM CALBOARD "
				   + " WHERE ID = ? "
				   + " AND SUBSTR(MDATE, 1, 8) = ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<CalDto> list = new ArrayList<CalDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, yyyyMMdd);
			System.out.println("3. query �غ� : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query ���� �� ����");
			
			while(rs.next()) {
				CalDto dto = new CalDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db ����");
		}
		
		return list;
	}
	
	public List<CalDto> getCalViewList(String id, String yyyyMM) {
		Connection con = getConnection();
		String sql = " SELECT * "
				   + " FROM "
				   + " ( "
				   + " SELECT (ROW_NUMBER() OVER(PARTITION BY SUBSTR(MDATE, 1, 8) ORDER BY MDATE)) RN, SEQ, ID, TITLE, CONTENT, MDATE, REGDATE "
				   + " FROM CALBOARD "
				   + " WHERE ID = ? "
				   + " AND SUBSTR(MDATE, 1, 6)= ? "
				   + " ) "
				   + " WHERE RN BETWEEN 1 AND 3 ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<CalDto> list = new ArrayList<CalDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, yyyyMM);
			System.out.println("3. query �غ� : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query ���� �� ����");
			
			while(rs.next()) {
				CalDto dto = new CalDto(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db ����");
		}
		
		return list;
	}
	
	
	
}
