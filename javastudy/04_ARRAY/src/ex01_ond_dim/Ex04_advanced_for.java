package ex01_ond_dim;

public class Ex04_advanced_for {
	
	public static void main(String[] args) {
		
		String[] friends= {"라이언","프로도","어피치"};
				for(int i=0; i<friends.length; i++) {
					System.out.println(friends[i]);
				}
			
				
		//1번째 친구 라이언
		//2번째 친구 프로도
        //3번째 친구 어피치
		
				
		//일반 for문		
		String[] friends2= {"라이언","프로도","어피치"};
		for(int i=0; i<friends2.length; i++) {
				System.out.println((i+1)+"번째 친구-"+friends2[i]);
				}
		
		
		// 향상 for문
		for(String friend:friends) { //friends 배열의 모든 요소를 하나씩 String friend로 옮긴다
			System.out.println(friend);
		}
		

		
		
		
		
}
	}
