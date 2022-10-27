package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.GesipanAddService;
import service.GesipanDetailService;
import service.GesipanEditService;
import service.GesipanListService;
import service.GesipanModifyService;
import service.GesipanRemoveService;
import service.GesipanService;

@WebServlet("*.do")

public class GesipanController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = requestURI.substring(contextPath.length());
		
	
		GesipanService service = null;
		
	
		ActionForward af = null;
		
	
		switch(urlMapping) {
	
		case "/gesipan/list.do":
			service = new GesipanListService();
			break;
		case "/gesipan/detail.do":
			service = new GesipanDetailService();
			break;
		case "/gesipan/add.do":
			service = new GesipanAddService();
			break;
		case "/gesipan/remove.do":
			service = new GesipanRemoveService();
			break;
		case "/gesipan/edit.do":
			service = new GesipanEditService();
			break;
		case "/gesipan/modify.do":
			service = new GesipanModifyService();
			break;
		// 단순이동(포워딩)
		case "/gesipan/write.do":
			af = new ActionForward();
			af.setView("/gesipan/write.jsp");
			af.setRedirect(false);
			break;
		}
		
		// 선택된 Service 실행
		try {
			if(service != null) {
				af = service.execute(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
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