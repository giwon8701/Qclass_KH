package com.answer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.answer.dto.AnswerDto;
import static com.answer.db.JDBCTemplate.*;

public class AnswerDaoImpl implements AnswerDao {

	@Override
	public List<AnswerDto> selectList() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<AnswerDto> list = new ArrayList<>();
		
		try {
			con = getConnection();
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			System.out.println("3. query 준비 : " + SELECT_LIST_SQL);
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				AnswerDto dto = new AnswerDto();
				dto.setBoardno(rs.getInt("BOARDNO"));
				dto.setGroupno(rs.getInt("GROUPNO"));
				dto.setGroupseq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setWriter(rs.getString(7));
				dto.setRegdate(rs.getDate(8));
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
	public AnswerDto selectOne(int boardno) {
		return null;
	}

	@Override
	public int insert(AnswerDto dto) {
		Connection con = null;
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			con = getConnection();
			pstm = con.prepareStatement(ANSWER_INSERT_SQL);
			System.out.println("3. query 준비 : " + ANSWER_INSERT_SQL);
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			
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
	public int update(AnswerDto dto) {
		return 0;
	}

	@Override
	public int delete(int Boardno) {
		return 0;
	}

	@Override
	public int answerProc(AnswerDto dto) {
		return 0;
	}

}
