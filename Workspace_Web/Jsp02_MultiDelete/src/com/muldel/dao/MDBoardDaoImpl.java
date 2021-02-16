package com.muldel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.muldel.db.JDBCTemplate.*;

import com.muldel.biz.MDBoardBiz;
import com.muldel.biz.MDBoardBizImpl;
import com.muldel.dto.MDBoardDto;

public class MDBoardDaoImpl implements MDBoardDao {
	
	MDBoardBiz biz = new MDBoardBizImpl();

	@Override
	public List<MDBoardDto> selectList() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			System.out.println("3. query 준비 : " + SELECT_LIST_SQL);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while (rs.next()) {
				MDBoardDto dto = new MDBoardDto();
				dto.setSeq(rs.getInt("SEQ"));
				dto.setWriter(rs.getString("WRITER"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setRegDate(rs.getDate("REGDATE"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db종료");
		}
		
		return list;
	}

	@Override
	public MDBoardDto selectOne(int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MDBoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MDBoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int multiDelete(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
