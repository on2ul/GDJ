package ex08_access_modifier;

public class UserMain {

	public static void main(String[] args) {
		
		User user = new User();
		
		user.setId("admin");
		System.out.println(user.getId());
		
		
		user.setpassword("123456789!");
		System.out.println(user.getpassword());
		
		user.setemail("admin123@naver.com");
		System.out.println(user.getemail());
		
		user.setPoint(10000);
		System.out.println(user.getepoint());
		System.out.println(user.getisVip());
	}

}
