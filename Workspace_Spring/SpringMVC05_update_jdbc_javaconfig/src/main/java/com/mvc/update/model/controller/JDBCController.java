package com.mvc.update.model.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.update.model.biz.JDBCBiz;

@Controller
public class JDBCController {

	@Autowired
	private JDBCBiz biz;
	
	private Logger logger = LoggerFactory.getLogger(JDBCController.class);
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		logger.info("[controller] list.do");
		
		model.addAttribute("list", biz.selectList());
		
		return "jdbclist";
	}
	
	@RequestMapping("/detail.do")
	public String selectOne(Model model, int seq) {
		logger.info("[controller] detail.do");
		
		model.addAttribute("dto", biz.selectOne(seq));
		
		return "jdbcdetail";
	}
	
}
