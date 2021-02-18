package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.mvc.db.JDBCTemplate.*;

import com.mvc.dto.MVCBoardDto;

public class MVCBoardDaoImpl implements MVCBoardDao {

	@Override
	public List<MVCBoardDto> selectList() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MVCBoardDto> list = new ArrayList<>();
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MVCBoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MVCBoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
