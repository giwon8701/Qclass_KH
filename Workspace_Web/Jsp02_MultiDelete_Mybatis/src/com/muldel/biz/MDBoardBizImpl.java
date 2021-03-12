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
		return dao.selectOne(number);
	}

	@Override
	public int insert(MDBoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MDBoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		return dao.delete(seq);
	}

	@Override
	public int multiDelete(String[] seq) {
		return dao.multiDelete(seq);
	}

}
