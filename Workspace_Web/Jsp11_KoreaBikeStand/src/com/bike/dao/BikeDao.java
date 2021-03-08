package com.bike.dao;

import static com.bike.db.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.bike.dto.BikeDto;

public class BikeDao {

	public boolean insert(List<BikeDto> list) {
		// list 전체 추가
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = " INSERT INTO KOREABIKE "
				   + " VALUES(?, ?, ?, ?, ?) ";
		int res = 0;
		int[] cnt = null;
		
		try {
			pstm = con.prepareStatement(sql);
			for (BikeDto dto : list) {
				pstm.setString(1, dto.getName());
				pstm.setString(2, dto.getAddr());
				pstm.setDouble(3, dto.getLatitude());
				pstm.setDouble(4, dto.getLongitude());
				pstm.setInt(5, dto.getBike_count());
				pstm.addBatch();
			}
			System.out.println("3. query 준비: " + sql);
			
			cnt = pstm.executeBatch();
			System.out.println("4. query 실행 및 리턴");
			
			for (int i=0; i<cnt.length; i++) {
				if (cnt[i] == -2) {
					res++;
				}
			}
			
			if (res == list.size()) {
				commit(con);
			} else {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		return (res == list.size()) ? true : false;
	}
	
	public boolean delete() {
		// db 전체 삭제
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = " DELETE FROM KOREABIKE ";
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 작성: " + sql);
			
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
			System.out.println("5. db 종료");
		}
		
		return (res > 0) ? true : false;
	}
}
