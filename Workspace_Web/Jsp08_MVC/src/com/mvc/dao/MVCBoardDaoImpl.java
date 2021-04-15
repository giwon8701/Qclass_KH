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
			System.out.println("3. query �غ� : " + SELECT_ALL_SQL);
			rs = pstm.executeQuery();
			System.out.println("4. query ���� �� ����");
			
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
		
		// 1 2. driver���� �� db����
		con = getConnection();
		
		// 3. query �غ�
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			System.out.println("3. Query �غ�" + SELECT_ONE_SQL);
			pstm.setInt(1, seq);
			
			
		// 4. query ���� �� ����
			rs = pstm.executeQuery();
			System.out.println("4. Query ���� �� ����");
			
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
			System.out.println("3. Query �غ�");
			res = pstm.executeUpdate();
			System.out.println("res : " + res);
			System.out.println("4. Query ���� �� ����");
			
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
			System.out.println("3. Query �غ� : " + UPDATE_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("4. Query ���� �� ����");
			
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db ����");
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
			System.out.println("3. Query �غ�");
			res = pstm.executeUpdate();
			System.out.println("res : " + res);
			System.out.println("4. Query ���� �� ����");
			
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
				// �޸𸮿� �����س���, executeBatch() �޼ҵ尡 ȣ�� �� ��, �ѹ��� ����!!!
				pstm.addBatch();
				System.out.println("3. query �غ� : " + DELETE_SQL + " (������ ��ȣ : " + seq[i] + ")");
			}
			// �޸𸮿� ����Ǿ��ִ� sql������ �ѹ��� ����!
			// int[] �� ���ϵ�!!!
			cnt = pstm.executeBatch();
			System.out.println("4. query ���� �� ����");
			
			// -2 : ����, -3 : ����
			for (int i=0; i<cnt.length; i++) {
				if (cnt[i] == -2) {
					res++;
				}
			}
			
			// ���� Ȯ��
			if (seq.length == res) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
