package com.gdu.app11.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app11.domain.EmpDTO;
import com.gdu.app11.mapper.EmpMapper;
import com.gdu.app11.util.PageUtil;


@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpMapper empMapper;
	
	@Autowired
	private PageUtil pageUtil;
	
	@Override
	public void findAllEmployees(HttpServletRequest request, Model model)  { // 리퀘스트를 받아오는 이유는 페이지라는 파라미터가 있기 때문
																			// 모델은 결과 명단을 저장하기 위해서!

		
		// request에서 page 파라미터 꺼내기
				// page 파라미터가 전달되지 않는 경우 page = 1로 처리한다.
				Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
				int page = Integer.parseInt(opt.orElse("1"));
				
				// 전체 레코드(직원) 개수 구하기
				int totalRecord = empMapper.selectAllEmployeesCount();
				
				// PageUtil 계산하기
				pageUtil.setPageUtil(page, totalRecord);
			
				// Map 만들기(begin, end)
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("begin", pageUtil.getBegin());
				map.put("end", pageUtil.getEnd());
				
				// begin~end 목록 가져오기
				List<EmpDTO> employees = empMapper.selectEmployeesByPage(map);
				
				// 뷰로 보낼 데이터
				model.addAttribute("employees", employees);
				model.addAttribute("paging", pageUtil.getPaging(request.getContextPath() + "/emp/list"));
				model.addAttribute("beginNo", totalRecord - (page - 1) * pageUtil.getRecordPerPage());

			}

			@Override
			public void findEmployees(HttpServletRequest request, Model model) {
				
				Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
				int page = Integer.parseInt(opt.orElse("1"));
				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("column", request.getParameter("column"));
				map.put("query", request.getParameter("query"));
				map.put("start", request.getParameter("start"));
				map.put("stop", request.getParameter("stop"));
				
				int totalRecord = empMapper.selectFindEmployeesCount(map);
				
				pageUtil.setPageUtil(page, totalRecord);
				
				map.put("begin", pageUtil.getBegin());
				map.put("end", pageUtil.getEnd());
				
				List<EmpDTO> employees = empMapper.selectFindEmployees(map);
				
				model.addAttribute("employees", employees);
				model.addAttribute("beginNo", totalRecord - (page - 1) * pageUtil.getRecordPerPage());
				model.addAttribute("paging", pageUtil.getPaging(request.getContextPath() + "/emp/search"));
				
			}
			
			
	
	
	
	

}
