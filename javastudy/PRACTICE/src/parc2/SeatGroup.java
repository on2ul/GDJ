package parc2;

import java.util.Scanner;

public class SeatGroup {

	
	private String seatType; // "S","R',"A"
	private Seat[] seats;
	private Scanner sc;
	
	// 생성자
	public SeatGroup(String seatType,int cnt) {
		this.seatType =seatType;
		seats = new Seat[cnt];
		for(int i=0; i<cnt; i++) {
			seats[i]=new Seat(); // 빈 좌석 가져다 두기
		}
		
		sc=new Scanner(System.in);
		
	}
	
	// 예약하는 메소드
	public boolean reserve() { //반환 타입이 void일때만 리턴으로 끝낼 수 있음
		reserveInfo(); // 예약 화면 띄우기
		
		//시트 번호는 1부터시작
		System.out.println("예약할 시트번호 >>> ");
		int seatNo=sc.nextInt();
		if(seatNo<1 || seatNo>seats.length) {
			System.out.println(seatNo+"번 좌석은 없는 좌석입니다.");
			return false;
		
		}
		// 예약된 시트인지 확인
		if(seats[seatNo-1].isOccupied()) {
			System.out.println(seatNo+"번 좌석은 이미 예약된 좌석입니다.");
			return false;
		}
		// 예약 진행
		System.out.println("예약자 이름 >>> ");
		String name =sc.next();
		seats[seatNo-1].reserve(name);
		System.out.println(seatNo+"번 좌석 예약이 완료되었습니다.");
		return true;
		
	}
	
	
	// 예약 취소하는 메소드
	public boolean cancel() {
		reserveInfo(); // 예약 화면 띄우기
		
		System.out.println("취소자 이름 >>>" );
		String name =sc.next();
		for(int i=0; i<seats.length; i++) {
			if(seats[i].isOccupied()) { //예약된 좌석만 비교
				if(seats[i].isMatched(name)) { //예약자 이름과 취소자 이름이 같으면 true,
					seats[i].cancel();
					System.out.println("예약자"+name+"의 예약이 취소되었습니다.");
					return true;
					
				}
		  }
	} // for문의 끝
	System.out.println(name+"으로 예약된 좌석이 없습니다.");
	return false;
	}
		
	
	
	// 예약 상황 출력 메소드
	// 이름 한 글자만 보여줌
	public void reserveInfo() {
		System.out.println("[" + seatType + "]");
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied()) {
				System.out.print(seats[i].getName().substring(0, 1) + "* ");
			} else {
				System.out.print((i + 1) + (i < 9 ? "   " : "  "));
			}
			if((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println(); //줄 바꿈
	}
	
}
