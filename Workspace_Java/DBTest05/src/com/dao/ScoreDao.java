package com.dao;

import java.util.List;

import com.dto.ScoreDto;

public interface ScoreDao {

	String SELECT_LIST_SQL = " SELECT S_NO, S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE "
						   + " FROM SCOREBOARD "
						   + " ORDER BY S_NO ";
	
	String SELECT_ONE_SQL = " SELECT S_NO, S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE "
						  + " FROM SCOREBOARD "
						  + " WHERE S_NO = ? ";
	
	String INSERT_SQL = " INSERT INTO SCOREBOARD "
					  + " VALUES(SCORESEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?) ";
	
	String UPDATE_SQL = " UPDATE SCOREBOARD "
					  + " SET S_NAME = ?, S_KOR = ?, S_ENG = ?, S_MATH =?, S_SUM = ?, S_AVG = ?, S_GRADE = ? "
					  + " WHERE S_NO = ? ";
	
	String DELETE_SQL = " DELETE FROM SCOREBOARD "
					  + " WHERE S_NO = ? ";
	
	String RANK_1ST_SQL = " SELECT S_NO, S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE "
						+ " FROM (SELECT * FROM SCOREBOARD ORDER BY S_SUM DESC) "
						+ " WHERE ROWNUM = 1 ";
	
	String RANK_2ND_SQL = " SELECT S_NO, S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE"
						+ " FROM (SELECT ROWNUM AS RNUM, A.* FROM (SELECT * FROM SCOREBOARD ORDER BY S_SUM DESC) A) B "
						+ " WHERE B.RNUM = 2 ";
	
	String RANK_3RD_SQL = " SELECT S_NO, S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE"
						+ " FROM (SELECT ROWNUM AS RNUM, A.* FROM (SELECT * FROM SCOREBOARD ORDER BY S_SUM DESC) A) B "
						+ " WHERE B.RNUM = 3 ";
	
	public List<ScoreDto> selectList();
	public ScoreDto selectOne(int s_no);
	public int insert(ScoreDto score);
	public int update(ScoreDto score);
	public int delete(int s_no);
	public ScoreDto select1st();
	public ScoreDto select2nd();
	public ScoreDto select3rd();
}
