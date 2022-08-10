package ex04_builder;

public class Main {

	public static void main(String[] args) {
		
		User user = User.builder()
				.userNo(1)
				.id("admin")
				.email("damin@naver.com")
				.build(); //마지막에 쓸 것 이대로 만드세요라는 의미
		
		System.out.println(user);
	}

}
