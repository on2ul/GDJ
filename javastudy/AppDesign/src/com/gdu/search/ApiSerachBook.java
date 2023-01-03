package com.gdu.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;



public class ApiSerachBook {

	public static void main(String[] args) {
	
		
		String clientId="f3wQMgFrsaiCFkYH8BnK";
		String clientSecret="0gA6IY2i1h";
		
		 try {
	         
	         Scanner sc = new Scanner(System.in);
	         System.out.println(" 책 제목을 입력하세요 >>>");
	         String send=sc.nextLine();
	         
	     
	         // UTF-8 URLEncoder.encode
	         
	         
	         // 주소 
	         
	         String apiURL = "https://openapi.naver.com/v1/search/book?query=" + send;
	         URL url = new URL(apiURL);
	         HttpURLConnection con = (HttpURLConnection)url.openConnection();
	         con.setRequestMethod("GET");
	         con.addRequestProperty("X-Naver-Client-Id", clientId);
	         con.addRequestProperty("X-Naver-Client-Secret", clientSecret);
	         
	         BufferedReader br = null;
	         
	        
	         if(con.getResponseCode()==HttpURLConnection.HTTP_OK) {
	            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         } else {
	            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	         }
	         
	         StringBuilder sb = new StringBuilder();
	         String line;
	         while((line = br.readLine()) != null) {
	            sb.append(line);
	         }
	         br.close();
	         sc.close();
	         con.disconnect();
	         
	        
	         JSONObject obj = new JSONObject(sb.toString());
	         JSONArray books = obj.getJSONArray("books");

	         
	         File dir =  new File("C:/download");
	         if(dir.exists() == false) {
	            dir.mkdirs();
	         }
	         File file = new File("C:/download", send + "."+".html");
	         PrintWriter out = new PrintWriter(file);
	         out.println("<!DOCTYPE html>");
	         out.println("<html>");
	         out.println("<head>");
	         out.println("<meta charset=\"UTF-8\">");
	         out.println("<title>책키라웃</title>");
	         out.println("</head>");         
	         out.println("<body>");
	         
	         
	         
	         out.println("</body>");
	         out.println("</html>");
	         out.close();
	         
	        System.out.println();
	        
	      } catch(Exception e) {
	    	  
	         try { 
        	    Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a h:mm:ss");
                String now=sdf.format(date);
	        	 
	            File dir = new File("C:/download/log");
	            if(dir.exists() == false) {
	               dir.mkdirs();
	            }
	            File file = new File(dir, "error_log.txt");
	            PrintWriter out = new PrintWriter(file);
	            out.println("예외메시지  " + e.getMessage());
	            out.println("예외발생시간 " + now);
	            out.close();
	         } catch(Exception e2) {
	            e2.printStackTrace();
	         }
	      }
	      
	      
	      
	      
	      
	   }
	}