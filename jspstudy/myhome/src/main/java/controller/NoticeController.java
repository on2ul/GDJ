package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.MemberService;
import service.MemberServiceImpl;
import service.NoticeServiceImpl;

@WebServlet("*.no")

public class NoticeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 / 응답 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 요청 확인
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = requestURI.substring(contextPath.length());
		
		// NoticeSeriviceImpl 객체 생성( Impl 생성)
		NoticeServiceImpl service = new NoticeServiceImpl();
		
		// ActionForward 객체
		ActionForward af = null;
		
		// 요청에 따른 Service 선택
		// Member service에서 만든 4개의 객체를 여기서 선택해서 사용
		switch(urlMapping) {
		case "/notice/list.no":
			 af=service.findAllNotices(request);
			 break;
		
		// 매핑 잘못 작성한 경우
		default:
			System.out.println("매핑을 확인하세요.");
		}
		
		// 어디로 어떻게 이동하는가?
		if(af != null) {
			if(af.isRedirect()) {
				response.sendRedirect(af.getView());
			} else {
				request.getRequestDispatcher(af.getView()).forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}