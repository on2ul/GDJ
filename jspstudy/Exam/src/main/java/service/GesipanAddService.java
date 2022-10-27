package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Gesipan;
import repository.GesipanDao;

public class GesipanAddService implements GesipanService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String editor= request.getParameter("editor");
		
		
		Gesipan gesipan = new Gesipan();
		gesipan.setTitle(title);
		gesipan.setContent(content);
		gesipan.setEditor(editor);
		
		
		int result = GesipanDao.getInstance().insertGesipan(gesipan);
	
		
		PrintWriter out=response.getWriter();
		if(result >0) {
			out.println("<script>");
			out.println("alert('게시글이 등록되었습니다.')");
			out.println("location.href='"+request.getContextPath()+"/gesipan/list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('게시글이 등록이 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
				
		}
		
		out.close();
		
		return null;
	
	
	}

}