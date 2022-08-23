package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class apiMain {

public static void main(String[] args) {
		
		// 도로교통공단 사망자교통사고 정보 서비스
	
		String serviceKey = "u9q+jLJB3mSOPBBf/HoxLxM4bSvvS2tO4sCPgQMZDbgL3WZTy3rxJmfOaUsK4DwgaMRHt4Zji1suNEi5kqbyHA==";
		
		
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			urlBuilder.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&startCreateDt=20220808");
			urlBuilder.append("&endCreateDt=20220812");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
			
		String apiURL = urlBuilder.toString();
		
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 접속 실패");
		}
		
	
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			
			reader.close();
			
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		
		
		String response = sb.toString();
		
		
		File file = new File("C:\\storage", "Accident.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
		}
	
	
			