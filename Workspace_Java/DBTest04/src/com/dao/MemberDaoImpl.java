package com.dao;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.MemberDto;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<MemberDto> selectList() {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SELECT_LIST_SQL);
			// 번호, 이름, 나이, 성별, 지역, 직업, 전화번호, 이메일
			while (rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setM_no(rs.getInt(1));
				dto.setM_name(rs.getString(2));
				dto.setM_age(rs.getInt(3));
				dto.setM_gender(rs.getString(4));
				dto.setM_location(rs.getString(5));
				dto.setM_job(rs.getString(6));
				dto.setM_tel(rs.getString(7));
				dto.setM_email(rs.getString(8));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}
		
		return list;
	}

	@Override
	public MemberDto selectOne(int m_no) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = SELECT_ONE_SQL;
		MemberDto dto = new MemberDto();
		
		try {
			// 3.
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, m_no);
			
			// 4.
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				dto.setM_no(rs.getInt(1));
				dto.setM_name(rs.getString(2));
				dto.setM_age(rs.getInt(3));
				dto.setM_gender(rs.getString(4));
				dto.setM_location(rs.getString(5));
				dto.setM_job(rs.getString(6));
				dto.setM_tel(rs.getString(7));
				dto.setM_email(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		return dto;
	}

	@Override
	public int insert(MemberDto dto) {
		// 1. 2. driver 및 게정 연결
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = INSERT_SQL;
		
		try {
			// 3. query 준비
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getM_name());
			pstm.setInt(2, dto.getM_age());
			pstm.setString(3, dto.getM_gender());
			pstm.setString(4, dto.getM_location());
			pstm.setString(5, dto.getM_job());
			pstm.setString(6, dto.getM_tel());
			pstm.setString(7, dto.getM_email());
			
			// 4. query 실행 및 리턴
			res = pstm.executeUpdate();
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
	public int update(MemberDto dto) {
		// 1. 2.
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = UPDATE_SQL;
		
		try {
			// 3. query 준비
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getM_name());
			pstm.setInt(2, dto.getM_age());
			pstm.setString(3, dto.getM_gender());
			pstm.setString(4, dto.getM_location());
			pstm.setString(5, dto.getM_job());
			pstm.setString(6, dto.getM_tel());
			pstm.setString(7, dto.getM_email());
			pstm.setInt(8, dto.getM_no());
			
			// 4. query 실행 및 리턴
			res = pstm.executeUpdate();
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
	public int delete(int m_no) {
		// 1. 2.
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = DELETE_SQL;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, m_no);
			
			res = pstm.executeUpdate();
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

}
