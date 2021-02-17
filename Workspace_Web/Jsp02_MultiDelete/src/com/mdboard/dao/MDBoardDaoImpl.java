package com.mdboard.dao;

import static com.mdboard.jdbc.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mdboard.dto.MDBoardDto;

public class MDBoardDaoImpl implements MDBoardDao {

	@Override
	public List<MDBoardDto> selectList() {
		List<MDBoardDto> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = con.prepareStatement(SQL_SELECT_LIST);
			rs = pstm.executeQuery();
			while(rs.next()) {
				MDBoardDto dto = new MDBoardDto();
				dto.setSeq(rs.getInt("SEQ"));
				dto.setWriter(rs.getString("WRITER"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setDate(rs.getDate("DATE"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		return list;
	}

	@Override
	public MDBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MDBoardDto dto = new MDBoardDto();
		
		try {
			pstm = con.prepareStatement(SQL_SELECT_ONE);
			pstm.setInt(1, seq);
			rs = pstm.executeQuery();
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setDate(rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int insert(MDBoardDto dto) {
		return 0;
	}

	@Override
	public int update(MDBoardDto dto) {
		return 0;
	}

	@Override
	public int delete(int seq) {
		return 0;
	}

	@Override
	public int multiDelete(String[] seq) {
		return 0;
	}

}
