package com.gdu.app11.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app11.domain.EmpDTO;
import com.gdu.app11.mapper.EmpMapper;


@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpMapper empMapper;
	
	
	@Override
	public void findAllEmployees(HttpServletRequest request, Model model) { // 리퀘스트를 받아오는 이유는 페이지라는 파라미터가 있기 때문
		// TODO Auto-generated method stub									// 모델은 결과 명단을 저장하기 위해서!

		
		// request에서 page 파라미터 꺼내기
		// page 파라미터가 전달되지 않는 경우 page =1로 처리한다.
		
		Optional<String> opt =Optional.ofNullable(request.getParameter("page"));
		int page=Integer.parseInt(opt.orElse("1"));
	
		int totalRecord=empMapper.selectAllEmployeesCount();
		
		int recordPerPage =10; // 한 페이지에 10개 하겠다
		int begin = (page -1 ) * recordPerPage+1; // (1-1)*10+1=1
												  // (2-1)*10+1=11
		
		int end=begin+recordPerPage-1; // 1+10-1
										// 11+10-1
										// 21+10-1
										// 51+10-1
	
		if(end>totalRecord) {   // end와 toralRecord를 비교해서 total값이 더 작으면
			end=totalRecord;   // totalRecord값을 end값으로 쓰겠다
		}
		
		List<EmpDTO> employees = empMapper.selectEmployeesByPage(begin, end);
		System.out.println(employees);
		
		model.addAttribute("employees",employees);
		
		
	}
	
	

}
