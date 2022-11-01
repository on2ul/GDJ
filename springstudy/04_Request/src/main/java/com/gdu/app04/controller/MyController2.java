package com.gdu.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app04.domain.Board;


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
	
	// 파라미터 처리법
	
	
	// 	<a herf="${contextPath}/board/detail1?title=공지사항&hit=10">전송</a>
	@GetMapping("detail1")
	public String detail1(HttpServletRequest request) { // 1.리퀘스트로 받기(추천)
		
		
		String title=request.getParameter("title");
		String hit=request.getParameter("hit");
		
		
		
		request.setAttribute("title", request.getParameter("title"));
		request.setAttribute("hit", request.getParameter("hit"));
		
		return "redirect:/board/detail2?title="+title+"&hit="+hit;  // 새로운 요청 /board/detail2?title="공지사항&hit=10 처리하시오
	}
	
	@GetMapping("detail2")
	public String detail2(String title, int hit,Model model) { // 2.변수로 받기. 변수로 받는다는건 리퀘스트 파람 이라는 애너테이션을 생략했다는 것
		model.addAttribute("title",title);					   // 모델은 jsp로 포워딩 할 때 사용
		model.addAttribute("hit",hit);
		
		return "board/detail";
	}
	
	/*
	 
	 속성(Attribute)전달 방식
	 
	  	구분					forward				redirect
	  -------------------------------------------------------------
	  인터페이스			Model				ReditectAttributes
	  메소드				addAttribyte() 		addFlashAttribute()
	  											addAttribute()는 forward 처럼 동작하므로 사용하지 말 것
	--------------------------------------------------------------  
	
	  
	 */
	
	
	
	
	
	
	
	
	
	
	// 	<a herf="${contextPath}/board/detail3?title=공지사항&hit=10">전송</a>
	@GetMapping("detail3")
	public String detail3(Board board  // 3.객체 만들어서 객체로 받기 .setTitle()과 stHit가 있어야 한다 . Board board로 공지사항과 10이 저장된 상태
						, RedirectAttributes redirectAttributes )  { // 리다이렉트 할때 속성을 보내주겠다
	
		redirectAttributes.addFlashAttribute("board", board); // 보드라는 이름으로 넘김
		return "redirect:/board/detail4"; // 새로운 요청에 파라미터를 추가하지 않았음을 주의할 것
		
	}
	
	@GetMapping("detail4")
	public String detail4() {
			return "board/detail"; // 보드 폴더 밑 detail.jsp 로 이동
		
	}

}
