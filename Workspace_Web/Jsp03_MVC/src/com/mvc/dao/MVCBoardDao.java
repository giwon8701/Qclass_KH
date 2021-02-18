package com.mvc.dao;

import java.util.List;

import com.mvc.dto.MVCBoardDto;

public interface MVCBoardDao {
	
	String SELECT_ALL_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MVCBOARD ";
	String SELECT_ONE_SQL = " SELECT WRITER, TITLE, CONTENT FROM MVCBOARD WHERE SEQ = ? ";
	
	public List<MVCBoardDto> selectList();
	public MVCBoardDto selectOne(int seq);
	public int insert(MVCBoardDto dto);
	public int update(MVCBoardDto dto);
	public int insert(int seq);
}
