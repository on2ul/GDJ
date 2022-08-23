package api;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Accident {

		private String occrrncDt; // 발생월일시 (2019011622)
		private String occrrncDayCd;  // 발생요일코드 (4)
		private int dthDnvCnt;  // 사망자수 (0)
		private int injpsnCnt;  // 부상자수 (1)
		

	public static void main(String[] args) {

	File file = new File("C:\\storage", "Accident.txt");
	List<apiMain> apiMains = new ArrayList<>();



	try {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(file);
		
		NodeList AccList = doc.getElementsByTagName("Accident");
		
		StringBuilder sb=new StringBuilder();
		Document root = null;
		NodeList items=root.getElementsByTagName("item"); // 태그 이름으로 찾기 getElement"s" 반환타입이 여러개라는 것~
		for(int i=0; i<items.getLength(); i++) {
			Node item=items.item(i);
			NodeList itemChildren=item.getChildNodes();
			for(int j=0;j<itemChildren.getLength();j++) {
				Node itemChild=itemChildren.item(j);
				if(itemChild.getNodeName().equals("String occrrncDt;")) {
					sb.append("발생일자 ").append(itemChild.getTextContent());
					
				}
				if(itemChild.getNodeName().equals("decideCnt")) {
					sb.append("사망자수").append(itemChild.getTextContent());
				}
				else if(itemChild.getNodeName().equals("deathCnt")) {
					sb.append(" 부상자수:").append(itemChild.getTextContent());
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
		
	}catch(Exception e) {
		e.printStackTrace();


		}
	}
	}




