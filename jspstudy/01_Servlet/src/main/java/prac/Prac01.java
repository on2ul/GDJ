package prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// http://lovalhost:9090/01_Servlet/now 주소를 입력하면
// 현재 날짜와 시간을 보여주기

@WebServlet("/now") // 1.먼저 바꿔주기
public class Prac01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Prac01() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글도 없고 파라미터도 없기 때문에 응답만 하면 됨
		
		// 응답 데이터 타입(MINE-TYPE)
		response.setContentType("text/html; charset=UTF-8");
		
		// 응답 스트림 생성
		PrintWriter out=response.getWriter();
		
		// 현재 날짜/시간 만들기
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;
		int day=cal.get(Calendar.DATE);
		int hour=cal.get(Calendar.HOUR);
		int minute=cal.get(Calendar.MINUTE);
		int second=cal.get(Calendar.SECOND);
		
		// 응답 만들기
		out.println("<h1>현재 시간은 "+year+"년"+month+"월"+day+"일"+hour+"시"+minute+"분"+second+"초 입니다.<h1>");
		
		out.flush(); 
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
