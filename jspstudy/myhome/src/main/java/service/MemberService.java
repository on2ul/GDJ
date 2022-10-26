package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public interface MemberService {
	
	// 서비스임플이 바뀌면 서비스도 한몸처럼 바뀐다 void->forward 변경
	public ActionForward login(HttpServletRequest request, HttpServletResponse response);
	public ActionForward logout(HttpServletRequest request, HttpServletResponse response);
	public void register(HttpServletRequest request, HttpServletResponse response);
	public void cancel(HttpServletRequest request, HttpServletResponse response);
}
