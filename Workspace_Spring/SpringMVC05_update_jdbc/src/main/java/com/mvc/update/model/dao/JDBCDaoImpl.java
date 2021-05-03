package com.mvc.update.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.update.model.dto.JDBCDto;

@Repository
public class JDBCDaoImpl implements JDBCDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<JDBCDto> selectList() {
		List<JDBCDto> list = new ArrayList<>();
		/*
		// 람다식 이용 방식
		list = jdbcTemplate.query(SELECT_LIST_SQL, (rs, rowNum) -> new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
		*/
		// inner class 방식
		list = jdbcTemplate.query(SELECT_LIST_SQL, null, null, new MyMapper());
		
		return list;
	}

	@Override
	public JDBCDto selectOne(int seq) {
		JDBCDto dto = null;

		dto = jdbcTemplate.queryForObject(SELECT_ONE_SQL, new Object[] {seq}, new int[] {Types.INTEGER}, new MyMapper());
		
		return dto;
	}

	@Override
	public int insert(JDBCDto dto) {
		
		int res = 0;

		res = jdbcTemplate.update(SELECT_ONE_SQL, new Object[] {dto.getWriter(), dto.getTitle(), dto.getContent()});
		
		return res;
	}

	@Override
	public int update(JDBCDto dto) {
		return 0;
	}

	@Override
	public int delete(int seq) {
		return 0;
	}
	
	// inner class
	private static final class MyMapper implements RowMapper<JDBCDto> {

		@Override
		public JDBCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
		}
		
	}

}
