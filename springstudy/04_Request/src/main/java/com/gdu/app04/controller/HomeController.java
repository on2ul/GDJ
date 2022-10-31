package com.gdu.app04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 이게 있어야 함!!!!!!!!!!!!!!!
public class HomeController {

	
	
// 웰컴페이지 등록	
	
@GetMapping("/")
	public String wlcome() {
		return "index";
}

}
