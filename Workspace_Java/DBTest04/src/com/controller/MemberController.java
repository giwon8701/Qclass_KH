package com.controller;

import java.util.List;
import java.util.Scanner;

import com.biz.MemberBiz;
import com.biz.MemberBizImpl;
import com.dto.MemberDto;

public class MemberController {

	private static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		int select = 0;
		
		StringBuffer sb = new StringBuffer();
		sb.append("*********\n")
		  .append("*1.전체 출력*\n")
		  .append("*2.선택 출력*\n")
		  .append("*3.추	가*\n")
		  .append("*4.수	정*\n")
		  .append("*5.삭	제*\n")
		  .append("*6.종	료*\n")
		  .append("input select : ");
		System.out.println(sb);
		select = sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
		int select = 0;
		MemberBiz biz = new MemberBizImpl();
		
		while (select != 6) {
			select = getMenu();
			
			switch (select) {
			// 1. 전체출력
			case 1:
				List<MemberDto> selectList = biz.selectList();
				for (MemberDto dto : selectList) {
					System.out.println(dto);
				}
				break;
				
			// 2. 선택출력
			case 2:
				System.out.println("번호를 입력해주세요 : ");
				int selectone_num = sc.nextInt();
				MemberDto selectOne = biz.selectOne(selectone_num);
				System.out.println(selectOne);
				break;
				
			// 3. 추가
			case 3:
				MemberDto insertDto = new MemberDto();
				// 추가 : 이름, 나이, 성별, 지역, 직업, 전화번호, 이메일
				System.out.println("이름을 입력해주세요 : ");
				insertDto.setM_name(sc.next());
				System.out.println("나이를 입력해주세요 : ");
				insertDto.setM_age(sc.nextInt());
				System.out.println("성별을 입력해주세요(M or F) : ");
				insertDto.setM_gender(sc.next());
				System.out.println("지역을 입력해주세요 : ");
				insertDto.setM_location(sc.next());
				System.out.println("직업을 입력해주세요 : ");
				insertDto.setM_job(sc.next());
				System.out.println("전화번호를 입력해주세요 : ");
				insertDto.setM_tel(sc.next());
				System.out.println("이메일을 입력해주세요 : ");
				insertDto.setM_email(sc.next());
				
				int insertRes = biz.insert(insertDto);
				if (insertRes > 0) {
					System.out.println("추가 성공");
				} else {
					System.out.println("추가 실패");
				}
				break;
				
			// 4. 수정
			case 4:
				MemberDto updateDto = new MemberDto();
				System.out.println("번호를 입력해주세요 : ");
				updateDto.setM_no(sc.nextInt());
				System.out.println("바꿀 이름을 입력해주세요 : ");
				updateDto.setM_name(sc.next());
				System.out.println("바꿀 나이를 입력해주세요 : ");
				updateDto.setM_age(sc.nextInt());
				System.out.println("바꿀 성별을 입력해주세요(M or F) : ");
				updateDto.setM_gender(sc.next());
				System.out.println("바꿀 지역을 입력해주세요 : ");
				updateDto.setM_location(sc.next());
				System.out.println("바꿀 직업을 입력해주세요 : ");
				updateDto.setM_job(sc.next());
				System.out.println("바꿀 전화번호를 입력해주세요 : ");
				updateDto.setM_tel(sc.next());
				System.out.println("바꿀 이메일을 입력해주세요 : ");
				updateDto.setM_email(sc.next());
				
				int updateRes = biz.update(updateDto);
				if (updateRes > 0) {
					System.out.println("수정 성공");
				} else {
					System.out.println("수정 실패");
				}
				break;
				
			// 5. 삭제
			case 5:
				System.out.println("삭제할 번호를 입력해주세요 : ");
				int deleteRes = biz.delete(sc.nextInt());
				
				if (deleteRes > 0) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("삭제 실패");
				}
				break;
				
			// 6. 종료
			case 6:
				break;
			}
		}
		System.out.println("프로그램 종료...");
	}
}
