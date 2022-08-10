package ex08_access_modifier;

public class User {
	
	// 필드는 private이다
	private String id;
	private String password;
	private String email;
	private int point;
	private boolean isVip;
	
	
	// 메소드는 public이다
	public String getId() {
		return id;
	}
	
	public void setId(String pId) {
		id=pId;
	}
	
	public String getpassword() {
		return password;
	}
	
	public void setpassword(String pPw) {
		password=pPw;
		
	}
	public String getemail() {
		return email;
			
	}	
	public void setemail(String pEmail) {
		email=pEmail;

	}	
	public int getepoint() {
		return point;
	
	}
	public void setPoint(int pPoint) {
		point=pPoint;
		setVip(point>=10000);
	}
	public boolean getisVip() {
		return isVip;
	}
	private void setVip(boolean pVip) {
		isVip=pVip;
	}

}

