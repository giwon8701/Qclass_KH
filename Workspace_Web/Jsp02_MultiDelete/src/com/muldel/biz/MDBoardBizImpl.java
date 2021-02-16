package com.muldel.biz;

import java.util.List;

import com.muldel.dao.MDBoardDao;
import com.muldel.dao.MDBoardDaoImpl;
import com.muldel.dto.MDBoardDto;

public class MDBoardBizImpl implements MDBoardBiz {

	MDBoardDao dao = new MDBoardDaoImpl();
	
	
	@Override
	public List<MDBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MDBoardDto selectOne(int number) {
		return null;
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
	public int multiDelete(int seq) {
		return 0;
	}

}
