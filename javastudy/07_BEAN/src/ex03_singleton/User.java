package ex03_singleton;

public class User {
	
	//static 필드
	//객체 생성 이전에 메모리에 미리 만들어두는 필드
	private static User user=new User(); //디폴트타입
	
	private User() { //User 객체 생성은 User 내부에서만 가능하다. 외부에서는 new User를 못한다
		
		
	}
	
	// static 메소드(클래스메소드)이다
	// 클래스가 생성될 때 함께 만들어지는 메소드
	// 객체 생성 이전에 만들어지기 때문에 객체로 접근하지 않는다.
	// 클래스 이름으로 접근한다.
	// User user = User.getinstance()       //return user; user가 반환된다
	public static User getInstance() {
		return user; 
		
	}
	
}
