package ex02_two_dim;

public class ddtdtdt {

	public static void main(String[] args) {
		
	
		int even = 0;  // 짝수 합
		int odd = 0;   // 홀수 합

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) { 
				even += i; 
			} else { 
				odd += i; 
			}
		}
		System.out.println("짝수 합:"+even);
		System.out.println("홀수 합;"+odd);
		

	}
}
