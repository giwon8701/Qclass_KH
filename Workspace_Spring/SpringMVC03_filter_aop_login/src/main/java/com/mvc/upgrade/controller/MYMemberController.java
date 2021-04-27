package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MYMemberBiz;
import com.mvc.upgrade.model.dto.MYMemberDto;

@Controller
public class MYMemberController {

	@Autowired
	private MYMemberBiz biz;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		return "mymemberlogin";
	}
	@RequestMapping("/registform.do")
	public String registForm() {
		return "mymemberregist";
	}
	
	/*
	 	@RequestBody	: request로 넘어오는 데이터를 java Object(객체)로 변환
	 	@ResponseBody	: java Object(객체)를 response 객체에 데이터로 binding
	 */
	@RequestMapping(value="/ajaxlogin.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody MYMemberDto dto) {
		
		MYMemberDto res = biz.login(dto);
		boolean check = false;
		if (res != null) {
			session.setAttribute("login", res);
			check = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	@RequestMapping(value="/regist.do", method=RequestMethod.POST)
	public String regist(MYMemberDto dto) {
		
		int res = biz.regist(dto);
		if (res > 0) {
			return "redirect:loginform.do";
		}
		
		return "redirect:registform.do";
	}
	
}
