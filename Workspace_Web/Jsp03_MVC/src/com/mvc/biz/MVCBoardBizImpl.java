package com.mvc.biz;

import java.util.List;

import com.mvc.dao.MVCBoardDao;
import com.mvc.dao.MVCBoardDaoImpl;
import com.mvc.dto.MVCBoardDto;

public class MVCBoardBizImpl implements MVCBoardBiz {
	
	MVCBoardDao dao = new MVCBoardDaoImpl();

	@Override
	public List<MVCBoardDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
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
