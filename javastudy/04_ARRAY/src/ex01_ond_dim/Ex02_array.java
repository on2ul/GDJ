package ex01_ond_dim;

public class Ex02_array {

	public static void main(String[] args) {
		
		// 배열의 초기화
		//int[] arr =new int[] {10,20,30,40,50};
		int[] arr = {10,20,30,40,50};
		
		
		// 최소/최대
		// 첫번째 요소를 초기값으로 쓴다
		// 1 ~ 100 사이의 값을 구하는 거라면 최소는 최대값을 최대는 최소값을준다
		int max=arr[0];
		int min=arr[0]; 
		
		for(int i=1;i<arr.length;i++) { //int i=1인 이유:max와 min을 arr[0](배열의 첫번째 요소)로 값으로 초기화 하였기 때문에 두번째요소인 1부터 비교하기 위해 
			if(max<arr[i]) {
				max = arr [i];
			}
			if(min >arr[i]) {
				min=arr[i];
			}
		}
		System.out.println("최대:"+max);
		System.out.println("최소:"+min);
		
		
		
		
		

	}

}
