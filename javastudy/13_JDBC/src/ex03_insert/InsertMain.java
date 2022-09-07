package ex03_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import domain.Board;

public class InsertMain {

	public static void main(String[] args) {
		
		// 게시판 정보를 입력 받아서 BOARD 테이블에 저장하기
		// 1.Scanner 클래스로 정보 입력 받기
		// 2.Board 클래스 타입의 객체에 입력받은 정보 저장하기
		
		Scanner sc =new Scanner(System.in);
		
		System.out.print("제목 >>> ");
		String title=sc.nextLine();
		
		System.out.print("내용 >>> ");
		String content=sc.nextLine();
		
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		
		
		Connection con=null;
		PreparedStatement ps=null;
		
		
		try {
			// OracleDriver 클래스 로드
			// OracleDriver 클래스가 저장된 ojdbc6.jar파일을 Classpath에 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			
			// DB접속 - Connection 객체 생성
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String user="SCOTT"; 
			String password="TIGER"; 
			con=DriverManager.getConnection(url, user, password);
			
			
			// 여기서 ?는 변수라는 뜻
			// 쿼리문 작성(변수 처리할 부분은 ?로 처리)
			// 제목과 내용을 사용자로부터 입력받아 ?로 넘겨준다
		    String sql = "INSERT INTO BOARD(BOARD_NO, TITLE, CONTENT, HIT, CREATE_DATE) VALUES (BOARD_SEQ.NEXTVAL, ?, ?, 0, SYSDATE)";
	
		    
		    // PreparedStatement 객체 생성
		    // Statement도 있으나 보안문제로 PreparedStatement 사용
		    // SQL INJECTION 공격으로부터 안전하려면 PreparedStatement 사용
			ps=con.prepareStatement(sql);
			
			
			// 쿼리문에 포함된 ?에 변수 전달
			// 쿼리문에 작성된 ?의 순서대로 채워줌
			ps.setString(1, board.getTitle()); // 1째 ?에 board.getTitle() 전달하기(set String:title이 String 이므로)
			ps.setString(2, board.getContent()); // 2번째 ?에 goard.getContent()전달하기
		
		
			// INSERT문의 실행
			// 1.executeUpdate() 메소드 사용하기
			// 2.execyteUpdate() 메소드의 반환값은 int 타입
			// 3. 반환값
			//	  1) 1이 반환되는 경우 : 1개의 행이 INSERT되었다는 의미.성공을 의미한다
			// 	  2) 0이 반환디는 경우 : 0개의 행이 INSERT되었다는 의미.실패를 의미한다
			
			int result=ps.executeUpdate();
			if(result ==1) {
				System.out.println("성공");
			} else {
					System.out.println("실패");
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
						if(ps!=null) ps.close();
						if(con!=null) ps.close();
						
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		
		}
	}


