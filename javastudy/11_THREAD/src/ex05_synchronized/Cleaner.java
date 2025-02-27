package ex05_synchronized;

	
// Cleaner 1개:공유 자원
	
	
// Cleaner 사용할 Robot 2개:스레드

	
// Robot이 Cleaner를 차지하기 위한 쟁탈전이 벌어짐	

// synchronized
// 1.스레드 충돌 방지를 위해서 한 번에 한 스레드만 접근할 수 있도록 허용
// 2.공유 자원의 일관성을 보장
// 3.한 번에 한 스레드만 접근할 수 있는 영역을 임계 영역(Critical Section)이라고 함
// (화장실 청소를 먼저 시작하면 화장실 청소를 다 끝내야만 방청소가 가능.중간에 클리너를 뺏을 수 없다)


// Object 클래스의 wait() 메소드
// 1.스레드가 대기 상태가 됨
// 2.다른 스레드가 깨울 때까지 대기한다


// Object 클래스의 notify() 메소드
// 1.다른 스레드를 깨움
// 2.notifyAll()메소드로 모든 스레드를 깨움

public class Cleaner {
	
	public synchronized void toiletCleaning() {
		try {
			System.out.println("화장실 청소");
			notify(); // "나 화장실 청소 끝났다"고 알림
			wait(); // 잠깐 쉼(wait메소드는 예외처리 필요)
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void roomCleaning() {
	try {	
		System.out.println("방 청소");
		notify(); // "나 방 청소 끝났다"고 알림
		wait(); // 잠깐 쉼
	}catch(InterruptedException e) {
		e.printStackTrace();
	}

	
	}

}
