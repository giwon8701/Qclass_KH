package com.myboard.dao;

import static com.myboard.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myboard.dto.MyBoardDto;

// Data Access Object
public class MyBoardDao {

	// ��ü ���
	public List<MyBoardDto> selectList() {
		
		// 1
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE "
				   + " FROM MYBOARD "
				   + " ORDER BY MYNO DESC ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query �غ� : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query ���� �� ����");
			while(rs.next()) {
				MyBoardDto dto = new MyBoardDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyname(rs.getString("MYNAME"));
				dto.setMytitle(rs.getString(3));
				dto.setMycontent(rs.getString("MYCONTENT"));
				dto.setMydate(rs.getDate(5));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. DB ����");
		}
		
		return list;
	}
	
	public MyBoardDto selectOne(int myno) {
		
		Connection con = getConnection();
		
		String sql = " SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE "
				   + " FROM MYBOARD "
				   + " WHERE MYNO = ? ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		MyBoardDto dto = new MyBoardDto();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("3. query �غ� : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query ���� �� ����");
			while (rs.next()) {
				dto.setMyno(rs.getInt("MYNO"));
				dto.setMyname(rs.getString(2));
				dto.setMytitle(rs.getString(3));
				dto.setMycontent(rs.getString(4));
				dto.setMydate(rs.getDate("MYDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db����");
		}
		
		
		return dto;
	}
	
	public int insert(MyBoardDto dto) {
		Connection con = getConnection();
		String sql = " INSERT INTO MYBOARD "
				   + " VALUES(MYBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			System.out.println("3. query �غ� : " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("4. query ���� �� ����");
			if (res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db����");
		}
		
		
		return res;
	}
	
	public int update(MyBoardDto dto) {
		Connection con = getConnection();
		String sql = " UPDATE MYBOARD SET MYNAME = ?, MYTITLE = ?, MYCONTENT = ? WHERE MYNO = ? ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			pstm.setInt(4, dto.getMyno());
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
			System.out.println("5. db����");
		}
		
		return res;
	}
	
	public int delete(MyBoardDto dto) {
		Connection con = getConnection();
		String sql = " DELETE FROM MYBOARD WHERE MYNO = ? ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getMyno());
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
			System.out.println("5. db����");
		}
		
		return res;
	}
}
