package ex01_thread;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("main 시작");

		Process process1 =new Process("연산");
		process1.start(); // Process 클래스의 오버라이드 된 run() 메소드가 호출된다(run을 직접 호출하는것이X)
	
		
		Process process2 =new Process("제어");
		process2.start();
		
		System.out.println("main 종료");
	}

}
