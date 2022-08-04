package ex03_finally;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// finally 블록
		// 1.try-catch문 마지막에 추가하는 블록
		// 2.언제나 마지막에 실행되는 블록
		// 3.생략 가능
		
		
		Scanner sc=new Scanner(System.in); // 메인블록으로 옮겼기 때문에 메인블록 안에서는 어디서든 쓸 수 있다
		try {
			System.out.println("나이 입력 >>>");
			String strAge=sc.nextLine();
			int age =Integer.parseInt(strAge);
			System.out.println(age>=20?"성인":"미성년자");
			//sc.close();   //여기 넣으면 안됨
		}catch(Exception e) {
			System.out.println("예외 발생");
		} finally {
			sc.close(); //여기 넣어야 함. 실제로 finally는 자원을 반납할 때 주로 사용 됨
			System.out.println("finally 블록 실행");
		}

	}

}
