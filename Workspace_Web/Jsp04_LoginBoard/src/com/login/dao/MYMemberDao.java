package com.login.dao;

import java.util.List;

import com.login.dto.MYMemberDto;

public class MYMemberDao {
	
	/*
	 * ������(ADMIN) ���
	 * 1. ȸ�� ��ü ���� Ȯ�� (Ż���� ȸ���� ����)
	 * 2. ȸ�� ��ü ���� Ȯ�� (MYENABLE='Y'�� -> Ż����� ȸ������ ����)
	 * 3. ȸ�� ��� ���� (ADMIN <-> USER)
	 */
	// 1. ��ü����
	public List<MYMemberDto> selectAllUser() {
		return null;
	}
	// 2. ��ü����(Ż�����)
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
		return null;
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
