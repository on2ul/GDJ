package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Gesipan;
import repository.GesipanDao;

public class GesipanListService implements GesipanService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		
		 List<Gesipan> gesipans =GesipanDao.getInstance().selectAllGesipans();
		 
	
		 request.setAttribute("gesipans", gesipans);
		 
		 
		
		 ActionForward af=new ActionForward();
		 af.setView("/gesipan/list.jsp"); 
		 af.setRedirect(false); // 포워드
		 return af;
	}

}