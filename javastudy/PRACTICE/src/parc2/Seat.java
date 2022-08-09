package parc2;

public class Seat {
	
	private String name; // 시트 예약한 사람 이름

	
	// 생성자는 없다
	
	
	
	// 예약한 사람 확인
	public String getName() {
		return name;
	}

	// 예약	
	public void reserve(String name) {
		this.name = name;
	}
	
	// 예약 취소
	public void cancel() {
		name=null;
	}
	
	// 예약 여부 확인
	public boolean isOccupied() {
		return name != null; //null이 아니면 true 반환(예약되어있으면 true 반환)
		
	}
	
	// 예약자 확인
	public boolean isMatched(String name) { //받아온 이름과 저장된 이름이 동일한지
		return name.equals(this.name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
