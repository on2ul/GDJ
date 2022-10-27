package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.GesipanDao;

public class GesipanRemoveService implements GesipanService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("gesipan_no"));
		int gesipan_no = Integer.parseInt(opt.orElse("0"));
		
		
		int result = GesipanDao.getInstance().deleteGesipan(gesipan_no);
		
		
		System.out.println("삭제 여부 : " + result);
		
		
		ActionForward af = new ActionForward();
		af.setView(request.getContextPath() + "/gesipan/list.do");  
		af.setRedirect(true);                                   
		return af;
		
	}

}