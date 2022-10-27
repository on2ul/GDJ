package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Gesipan;
import repository.GesipanDao;

public class GesipanEditService implements GesipanService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("gesipan_no"));
		int gesipan_no = Integer.parseInt(opt.orElse("0"));
		
	
		Gesipan gesipan = GesipanDao.getInstance().selectGesipanByNo(gesipan_no);
		
	
		request.setAttribute("gesipan", gesipan);
		
	
		ActionForward af = new ActionForward();
		af.setView("/gesipan/edit.jsp");  
		af.setRedirect(false); 
		return af;
		
	}

}
