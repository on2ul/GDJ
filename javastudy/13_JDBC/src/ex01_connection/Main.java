package ex01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		
		// OracleDriver 열기(메모리에 로드하기)
		// 1.oracle.jdbc.OracleDriver
		// 2.oracle.jdbc.driver.OracleDriver
		
	try {
		Class.forName("oracle.jdbc.OracleDriver");
			
		}catch(ClassNotFoundException e) {
			System.out.println("OravleDriver 로드 실패");
		}
		
	
		// DriverManager로부터 Connection 받아오기
		Connection con =null;
	
	try {
		String url ="jdbc:oracle:thin:@localhost:1521:xe"; // DB마다 url은 달라진다(Oracle XE 버전 기준)
		String user="SCOTT"; // 대소문자 상관 없다
		String password="TIGER"; // 계정 만들 때 사용한 대소문자 지켜야 한다
		
		con=DriverManager.getConnection(url, user, password);
		
		System.out.println("DB접속 성공");
		
	} catch(SQLException e) {
		System.out.println("DB접속정보 오류");
	}
	
	
	// Connection 종료 
	// 접속-작업-종류 순서 중요함
	// JDBC에서는 Connection을 닫는 것이 굉장히 중요하다
try {
	if(con !=null)

	con.close();
	
	
	} catch(SQLException e) {
		e.printStackTrace();
	}
	
	}
}

