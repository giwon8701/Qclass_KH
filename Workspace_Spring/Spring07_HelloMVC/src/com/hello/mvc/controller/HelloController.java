package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.biz.HelloBiz;

@Controller
public class HelloController {

	// TODO : 05. Biz(@Service) 호출
	@Autowired
	private HelloBiz biz;
	
	// TODO : 04. HandlerMapping을 통해, hello.do로 넘어온 요청이 Controller의 해당 method를 찾아옴
	@RequestMapping("/hello.do")
	public String getHello(Model model) {
		
		// TODO : 09. return 받은 값을 model 객체에 담아서 전달(ModelAndView)
		model.addAttribute("message", biz.getHello());
		
		// TODO : 10. view
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/bye.do")
	public ModelAndView getBye(@RequestParam("name") String nickname) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message", "bye, " + nickname);
		
		return mav;
	}
}


/*

@RequestMapping (= 서블릿 호출명)
- url을 class 또는 method와 mapping시켜주는 역할

@RequestParam (= String command=request.getparameter)
- key=value 형태로 넘어오는 파라미터를 mapping된 method의 파라미터로 지정

@ModelAttribute
- form tag를 통해 넘어온 model을 mapping된 method의 파라미터로 지정

@SessionAttribute
- session에서 model의 정보를 유지하고 싶을 경우 사용

*/