package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.MyBoardDto;
import static com.board.jdbc.JDBCTemplate.*;

public class MyBoardDao {
	
	public List<MyBoardDto> selectList() {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		List<MyBoardDto> list = new ArrayList<>();
		
		// 1 2. driver연결 및 db 연결
		con = getConnection();
		
		// 3. query 준비
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MYBOARD ORDER BY SEQ DESC ";
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. Query 준비");
			
			rs = pstm.executeQuery();
			System.out.println("4. Query 실행 및 리턴");
			
			while (rs.next()) {
				MyBoardDto dto = new MyBoardDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		return list;
	}
	
	public MyBoardDto selectOne(int seq) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyBoardDto dto = new MyBoardDto();
		
		// 1 2. driver연결 및 db연결
		con = getConnection();
		
		// 3. query 준비
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MYBOARD WHERE SEQ = ?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			
			
		// 4. query 실행 및 리턴
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		return dto;
	}
	
	public int insert(MyBoardDto dto) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		int res = 0;
		
		con = getConnection();
		
		String sql = " INSERT INTO MYBOARD VALUES(MYBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			res = pstm.executeUpdate();
			
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	
	public int update(MyBoardDto dto) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		int res = 0;
		
		con = getConnection();
		
		String sql = " UPDATE MYBOARD SET TITLE = ?, CONTENT = ? WHERE = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			
			res = pstm.executeUpdate();
			
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	
	public int delete(int seq) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		int res = 0;
		
		con = getConnection();
		String sql = " DELETE FROM MYBOARD WHERE = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			
			res = pstm.executeUpdate();
			
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}

}
