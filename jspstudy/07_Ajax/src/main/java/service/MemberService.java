package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	
	// 액션포워드를 반환하지 않는다
	// mvc는 페이지 이동이 있고 ajax는 페이지 이동이 없는 방식이다
	public void execute(HttpServletRequest request, HttpServletResponse response)throws Exception;

	
}
