package com.boot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.model.biz.MyBoardBiz;
import com.boot.jdbc.model.dto.MyDto;

@Controller
@RequestMapping("/myboard")
public class MyBoardController {
	
	@Autowired
	private MyBoardBiz biz;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "myboardlist";
	}
	
	@GetMapping("/detail")
	public String selectOne(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myboardselect";
	}
	
	@GetMapping("/updateform")
	public String updateForm(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myboardupdate";
	}
	
	@PostMapping("/updateres")
	public String updateRes(MyDto dto) {
		if (biz.update(dto) > 0) {
			return "redirect:/myboard/detail?myno="+dto.getMyno();
		}
		
		
		return "redirect:/myboard/updateform?myno="+dto.getMyno();
	}
	
	@GetMapping("/delete")
	public String delete(int myno) {
		if (biz.delete(myno) > 0) {
			return "redirect:/myboard/list";
		}
		return "redirect:/myboard/detail?myno="+myno;
	}
	
	@GetMapping("/insertform")
	public String insertForm() {
		return "myboardinsert";
	}
	@PostMapping("/insertres")
	public String insertRes(MyDto dto) {
		if (biz.insert(dto) > 0) {
			return "redirect:/myboard/list";
		}
		return "redirect:/myboard/insertform";
	}
	
	

}
