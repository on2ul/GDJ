package com.gdu.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 이거 있어야 한다 까먹지마셈
public class ContactController {
	
	
	
// 웰컴페이지 등록
@GetMapping("/")
	public String index() {
		return "index";
	}	



}





	
	
