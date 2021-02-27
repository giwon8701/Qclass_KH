package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.biz.MVCBoardBiz;
import com.mvc.biz.MVCBoardBizImpl;
import com.mvc.dto.MVCBoardDto;

@WebServlet("/MVCController")
public class MVCBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MVCBoardBiz biz = new MVCBoardBizImpl();
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		
		if (command.equals("list")) {
			// 1. 보내준 값 있으면 받기
			// 2. db 호출 (전달할 값 있으면 전달)
			List<MVCBoardDto> list = biz.selectList();
			// 3. 화면에 보내줄 값 있으면 request객체에 담기
			request.setAttribute("list", list);
			// 4. 보내기
			dispatch(request, response, "mvclist.jsp");
		} else if (command.equals("select")) {
			// 1. 보내준 값 있으면 받기
			int seq = Integer.parseInt(request.getParameter("seq"));
			// 2. db 호출 (전달할 값 있으면 전달)
			MVCBoardDto dto = biz.selectOne(seq);
			// 3. 화면에 보내줄 값 있으면 request객체에 담기
			request.setAttribute("dto", dto);
			// 4. 보내기
			dispatch(request, response, "mvcselect.jsp");
		} else if (command.equals("updateform")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			MVCBoardDto dto = biz.selectOne(seq);
			request.setAttribute("dto", dto);
			dispatch(request, response, "mvcupdate.jsp");
		} else if (command.equals("updateres")) {
			// 1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			// 2.
			MVCBoardDto dto = new MVCBoardDto(seq, null, title, content, null);
			int res = biz.update(dto);
			// 3.
			// 4.
			if (res > 0) {
				// forward를 하면 request가 계속 연결되어 있기 때문에 새로고침 시 값이 계속 전달된다.
				response.sendRedirect("mvc.do?command=select&seq="+seq);
			} else {
				response.sendRedirect("mvc.do?command=updateform&seq="+seq);
			}
		} else if (command.equals("delete")) {
			// 1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			// 2.
			int res = biz.delete(seq);
			// 3.
			// 4.
			if (res > 0) {
				dispatch(request, response, "mvc.do?command=list");
			} else {
				dispatch(request, response, "mvc.do?command=select&seq="+seq);
			}
		} else if (command.equals("insertform")) {
			// 1.
			// 2.
			// 3.
			// 4.
			response.sendRedirect("mvcinsert.jsp");
		} else if (command.equals("insertres")) {
			// 1.
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			// 2.
			MVCBoardDto dto = new MVCBoardDto(0, writer, title, content, null);
			int res = biz.insert(dto);
			// 3.
			// 4.
			if (res > 0) {
				response.sendRedirect("mvc.do?command=list");
			} else {
				response.sendRedirect("mvc.do?command=insertform");
			}
			
		} else if (command.equals("multidelete")) {
			// 1.
			String[] 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

}
