package com.gdu.app11.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface EmpService {

	// request,response,session,model의 최초선언은 controller만 가능하다
	// 서비스는 다 컨트롤러에서 받아오는거임
	public void findAllEmployees(HttpServletRequest request, Model model);
	public void findEmployees(HttpServletRequest request, Model model);
	public Map<String, Object> findAutoCompleteList(HttpServletRequest request);
}
