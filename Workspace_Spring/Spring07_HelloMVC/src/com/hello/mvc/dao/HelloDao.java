package com.hello.mvc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
	
	// TODO : 07. Dao에서 return (db랑 연결하는 코드가 들어감)
	public String getHello() {
		return "Spring";
	}
}
