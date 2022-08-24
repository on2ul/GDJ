package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class ApiMain {

	public static void main(String[] args) {
		
		// XML 파싱
		// API응답(XML) -> XML파일 -> Document로 읽음
		
		// JSON 파싱
		// API응답(JSON) -> JSONObject로 바꿔줌 (중간에 파일 생성 과정이 필요하지 X)
		
		try {
			
			 String apiURL="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000"; // 주소자체에 파라미터가 붙어있음 "?"
				
			 URL url =new URL(apiURL);
			 HttpURLConnection con=(HttpURLConnection)url.openConnection();
				
				
				// 안적어도 지장 없음
				// con.setRequestMethod("GET");
				// con.setRequsetProperty("Content-Type","application/xml; charset=UTF-8");
			

			 StringBuilder sb = new StringBuilder();
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line = null;
				while((line = br.readLine()) != null) {
					sb.append(line);
				}
				
				// 파싱 결과를 저장할 파일
				File file = new File("weather.txt");
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			 
			// StringBuilder에 저장된 응답(XML) 데이터를 JSON으로 변경하기
				JSONObject obj = XML.toJSONObject(sb.toString());
				JSONObject rss = obj.getJSONObject("rss");
				JSONObject channel = rss.getJSONObject("channel");
				String link = channel.getString("link");
				String description = channel.getString("description");
				String generator = channel.getString("generator");
				String language = channel.getString("language");
				String title = channel.getString("title");
				String pubDate = channel.getString("pubDate");
				bw.write(pubDate + "\n");
				JSONObject item = channel.getJSONObject("item");
				String author = item.getString("author");
				String link2 = item.getString("link");
				String category = item.getString("category");
				bw.write(category + "\n");
				String title2 = item.getString("title");
				JSONObject description2 = item.getJSONObject("description");
				JSONObject body = description2.getJSONObject("body");
				JSONArray dataList = body.getJSONArray("data");
				for(int i = 0; i < dataList.length(); i++) {
					JSONObject data = dataList.getJSONObject(i);
					int sky = data.getInt("sky");
					int temp = data.getInt("temp");
					String wfKor = data.getString("wfKor");
					int wd = data.getInt("wd");
					int hour = data.getInt("hour");
					bw.write(hour + "시, " + temp + "도, " + wfKor + "\n");
				}
				
				bw.close();
				br.close();
				con.disconnect();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}

	}