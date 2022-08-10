package ex14_interface;

public interface Shape {
	
	
	
	
	// final 상수(interface는 상수값을 가질 수 있다)
	public final static double PI=3.141592;
	
	// 추상 메소드
	//public abstract double getArea();// abstract 생략가능
	public double getArea(); 
	
	
	// default 메소드(본문이 있는 메소드)
	public default void message() {
		System.out.println("나는 도형이다.");
	}
	
	
	
	
}
