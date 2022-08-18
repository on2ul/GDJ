package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Main {

	public static void main(String[]args) {
		
	String key="4fd727796f0ee17632a925a38a1cb315";
	
	 Scanner sc=new Scanner(System.in);
	 System.out.println("날짜(yyyymmdd) >>> ");
	 String targetDt=sc.next();
	 
	 try {
		 key=URLEncoder.encode(key,"UTF-8");
		 targetDt=URLEncoder.encode(targetDt,"UTF-8");
		
	 }catch(UnsupportedEncodingException e) {
		 throw new RuntimeException("인코딩 실패",e);
		 
	 }
	 
	 // 파라미터 붙이고 싶으면 ?하고 붙이기~
	 // 주소 만들때 공백 있으면 안됨
	 String apiURL="http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key="+key+"&targetDt="+targetDt;
	 
	 // 메소드화
	 String response=getResponse(apiURL);
	 System.out.println(response);
	 createFile(response);
	 
	
	}
	
	public static String getResponse(String apiURL) { // 얘는 응답하는 메소드
		HttpURLConnection con = getConnection(apiURL);
		try {
			if(con.getResponseCode()==HttpURLConnection.HTTP_OK) {
				return readBody(con.getInputStream());
			}else {
				return readBody(con.getErrorStream());
			}
		}catch(IOException e) {
			throw new RuntimeException("API 요청 오류",e);
		}
	}
	
	public static HttpURLConnection getConnection(String apiURL) {
	
		try {
			URL url=new URL(apiURL);
			return(HttpURLConnection)url.openConnection();
		}catch(MalformedURLException e) {
			throw new RuntimeException("API 주소 오류",e);
		}catch(IOException e) {
			throw new RuntimeException("API 연결 오류",e);
			
		}
		
	}
	
	public static String readBody(InputStream in) {
		
		try(BufferedReader br=new BufferedReader(new InputStreamReader(in))){
			StringBuilder sb=new StringBuilder();
			String line=null;
			
			while((line=br.readLine())!=null) {
				sb.append(line);
			}
			return sb.toString();
		}catch(IOException e) {
			throw new RuntimeException("API 응답 실패",e);
		}
	}
	
	public static void createFile(String response) {
		try(BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\storage\\boxoffice.xml"))) {
		bw.write(response);
		bw.flush();	
	} catch(IOException e) {
		throw new RuntimeException("파일 생성 오류",e);
	}
	
}
	
	
}
