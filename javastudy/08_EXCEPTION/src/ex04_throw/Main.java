package ex04_throw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//throw
		// 1.예외 객체를 만들어서 직접 throw 할 수 있다. 
		// 2. 자바는 예외로 인식하지 않지만 실제로는 예외인 경우에 주로 사용된다.예를 들면 나이를 오만살 입력했을 경우
		
		
		
		
		Scanner sc=new Scanner(System.in); // 메인블록으로 옮겼기 때문에 메인블록 안에서는 어디서든 쓸 수 있다
		try {
			System.out.println("나이 입력 >>>");
			String strAge=sc.nextLine();
			int age =Integer.parseInt(strAge);
			if(age<0 || age>100) {
				throw new RuntimeException("나이는 0 이상 100 이하만 가능합니다."); //1)throw가 던지면
			}
			System.out.println(age>=20?"성인":"미성년자");
			//sc.close();   //여기 넣으면 안됨
		}catch(Exception e) { //2)chtch(e)가 받는다 
			System.out.println(e.getMessage()); //"나이는 0 이상 100 이하만 가능합니다" 메시지는 e에 들어있다.
		} finally {								// 예외메시지는 getMessage로 확인할 수 있다.
			sc.close(); //여기 넣어야 함. 실제로 finally는 자원을 반납할 때 주로 사용 됨
			System.out.println("finally 블록 실행");
		}

	}

}
