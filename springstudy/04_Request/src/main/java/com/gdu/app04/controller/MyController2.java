package com.gdu.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("board") // URL Mapping이 board로 시작하는 모든 요청을 처리하는 컨트롤러
@Controller
public class MyController2 {
	
	
	/*
	   까먹으면 죽음 뿐이다
	   
	   1.forward (JSP)
	   return "board/detail";
	   board 폴더 아래에 detail.jsp로 forward 하시오 
	   
	   2.redirect (Mapping)
	   return "redirect:/board/detail";
	   URL Mapping값이 /board/detail인 새로운 요청으로 redirect 하시오
	   
	 */
	
	// 	<a herf="${contextPath}/board/detail1?title=공지사항&hit=10">전송</a>
	@GetMapping("detail1")
	public String detail1(HttpServletRequest request) {
		
		
		String title=request.getParameter("title");
		String hit=request.getParameter("hit");
		
		
		
		request.setAttribute("title", request.getParameter("title"));
		request.setAttribute("hit", request.getParameter("hit"));
		
		return "redirect:/board/detail2?title="+title+"&hit="+hit;  // 새로운 요청 /board/detail2?title="공지사항&hit=10 처리하시오
	}
	
	@GetMapping("detail2")
	public String detail2(String title, int hit,Model model) {
		model.addAttribute("title",title);
		model.addAttribute("hit",hit);
		
		return "board/detail";
	}


}
