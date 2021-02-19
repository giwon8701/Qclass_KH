package com.login.dao;

import static com.login.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.login.dto.MYMemberDto;

public class MYMemberDao {
	
	/*
	 * ������(ADMIN) ���
	 * 1. ȸ�� ��ü ���� Ȯ�� (Ż���� ȸ���� ����)
	 * 2. ȸ�� ��ü ���� Ȯ�� (MYENABLE='Y'�� -> Ż����� ȸ������ ����)
	 * 3. ȸ�� ��� ���� (ADMIN <-> USER)
	 */
	// 1. ��ü����(Ż��ȸ�� ����)
	public List<MYMemberDto> selectAllUser() {
		return null;
	}
	// 2. ��ü����(Ż����� ȸ����)
	public List<MYMemberDto> selectEnabledUser() {
		return null;
	}
	// 3. ȸ�� ��� ����
	public int updateRole(int myno, String myrole) {
		return 0;
	}
	
	/*
	 * �����(USER) ���
	 * 1. �α���
	 * 3. ȸ������ <- 2. ���̵� �ߺ�üũ
	 * 4. �� ���� ��ȸ
	 * 5. �� ���� ����
	 * 6. ȸ�� Ż�� (delete �Ⱦ���! update : myenabled�� n���� �ٲ���.)
	 * 
	 */
	
	// 1. �α���
	public MYMemberDto login(String myid, String mypw) {
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				   + " FROM MYMEMBER "
				   + " WHERE MYID = ? "
				   + " AND MYPW = ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		// side effect // id or pw�� Ʋ���� sql������ ������ �� ��� null ���·� ���Եǰ�, �������� dto�� null���·� ���ϵȴ�.
		MYMemberDto dto = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			pstm.setString(2, mypw);
			System.out.println("3. query �غ� : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query ���� �� ����");
			while(rs.next()) {
				dto = new MYMemberDto();
				dto.setMyno(rs.getInt("MYNO"));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
			System.out.println("5. db ����");
		}
		
		return dto;
	}
	// 2. �ߺ�üũ
	public MYMemberDto idCheck(String myid) {
		return null;
	}
	// 3. ȸ������
	public int insertUser(MYMemberDto dto) {
		return 0;
	}
	// 4. ���� ��ȸ
	public MYMemberDto selecUser(int myno) {
		return null;
	}
	// 5. ���� ����
	public int updateUser(MYMemberDto dto) {
		return 0;
	}
	// 6. ȸ�� Ż�� (update)
	public int deleteUser(int myno) {
		return 0;
	}

}
