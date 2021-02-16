package com.muldel.dao;

import java.util.List;

import com.muldel.dto.MDBoardDto;

public interface MDBoardDao {

	String SELECT_LIST_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MDBOARD ";
	String SELECT_ONE_SQL = "";
	String INSERT_SQL = "";
	String UPDATE_SQL = "";
	String DELETE_SQL = "";
	
	public List<MDBoardDto> selectList();
	public MDBoardDto selectOne(int number);
	public int insert(MDBoardDto dto);
	public int update(MDBoardDto dto);
	public int delete(int seq);
	
	public int multiDelete(int seq);
}