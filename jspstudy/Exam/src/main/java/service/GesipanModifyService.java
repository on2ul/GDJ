package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Gesipan;
import repository.GesipanDao;

public class GesipanModifyService implements GesipanService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int gesipan_no = Integer.parseInt(request.getParameter("gesipan_no"));
		
	
		Gesipan gesipan = new Gesipan();
		gesipan.setTitle(title);
		gesipan.setContent(content);
		gesipan.setGesipan_no(gesipan_no);
		
	
		int result = GesipanDao.getInstance().updateGesipan(gesipan);
		
	
		System.out.println("수정 결과 : " + result);
		
		
		ActionForward af = new ActionForward();
		af.setView(request.getContextPath() + "/gesipan/detail.do?gesipan_no=" + gesipan_no);  
		af.setRedirect(true);                                                          
		return af;
		
	}

}