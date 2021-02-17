package com.mdboard.dao;

import java.util.List;

import com.mdboard.dto.MDBoardDto;

public interface MDBoardDao {

	String SQL_SELECT_LIST = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MDBOARD ORDER BY SEQ DESC ";
	String SQL_SELECT_ONE = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MDBOARD WHERE SEQ = ? ";
	String SQL_INSERT = " INSERT INTO MDBOARD VALUES(MDBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
	String SQL_UPDATE = " UPDATE MDBOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ? ";
	String SQL_DELETE = " DELETE FROM MDBOARD WHERE SEQ = ? ";
	
	public List<MDBoardDto> selectList();
	public MDBoardDto selectOne(int seq);
	public int insert(MDBoardDto dto);
	public int update(MDBoardDto dto);
	public int delete(int seq);
	
	public int multiDelete(String[] seq);
}
