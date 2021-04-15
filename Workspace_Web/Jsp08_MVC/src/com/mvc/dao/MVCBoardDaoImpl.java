package com.mvc.dao;

import static com.mvc.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MVCBoardDto;

public class MVCBoardDaoImpl implements MVCBoardDao {
	
	@Override
	public List<MVCBoardDto> selectList() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MVCBoardDto> list = new ArrayList<>();
		
		
		Connection con = getConnection();
		
		try {
			con = getConnection();
			pstm = con.prepareStatement(SELECT_ALL_SQL);
			System.out.println("3. query 준비 : " + SELECT_ALL_SQL);
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			
			while(rs.next()) {
				MVCBoardDto dto = new MVCBoardDto();
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

	@Override
	public MVCBoardDto selectOne(int seq) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MVCBoardDto dto = new MVCBoardDto();
		
		// 1 2. driver연결 및 db연결
		con = getConnection();
		
		// 3. query 준비
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			System.out.println("3. Query 준비" + SELECT_ONE_SQL);
			pstm.setInt(1, seq);
			
			
		// 4. query 실행 및 리턴
			rs = pstm.executeQuery();
			System.out.println("4. Query 실행 및 리턴");
			
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
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

	@Override
	public int insert(MVCBoardDto dto) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		int res = 0;
		
		con = getConnection();
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("3. Query 준비");
			res = pstm.executeUpdate();
			System.out.println("res : " + res);
			System.out.println("4. Query 실행 및 리턴");
			
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}

	@Override
	public int update(MVCBoardDto dto) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		int res = 0;
		
		con = getConnection();
		
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("3. Query 준비 : " + UPDATE_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("4. Query 실행 및 리턴");
			
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		return res;
	}

	@Override
	public int delete(int seq) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		int res = 0;
		
		con = getConnection();
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setInt(1, seq);
			System.out.println("3. Query 준비");
			res = pstm.executeUpdate();
			System.out.println("res : " + res);
			System.out.println("4. Query 실행 및 리턴");
			
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

	@Override
	public int multiDelete(String[] seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		int[] cnt = null;
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			for (int i=0; i<seq.length; i++) {
				pstm.setString(1, seq[i]);
				// 메모리에 적재해놓고, executeBatch() 메소드가 호출 될 때, 한번에 실행!!!
				pstm.addBatch();
				System.out.println("3. query 준비 : " + DELETE_SQL + " (삭제할 번호 : " + seq[i] + ")");
			}
			// 메모리에 적재되어있는 sql문들을 한번에 실행!
			// int[] 로 리턴됨!!!
			cnt = pstm.executeBatch();
			System.out.println("4. query 실행 및 리턴");
			
			// -2 : 성공, -3 : 실패
			for (int i=0; i<cnt.length; i++) {
				if (cnt[i] == -2) {
					res++;
				}
			}
			
			// 갯수 확인
			if (seq.length == res) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
