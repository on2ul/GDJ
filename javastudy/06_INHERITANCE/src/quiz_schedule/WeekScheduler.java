package quiz_schedule;

import java.util.Scanner;

public class WeekScheduler {

	private int nthWeek; // 1 ~n주차
	private String[] dayNames= {"일","월","화","수","목","금","토"}; //2)이름 생성
	private Day[] week;
	private Scanner sc;
	
	public WeekScheduler(int nthWeek) {
		this.nthWeek=nthWeek;
		week= new Day[7];
		sc=new Scanner(System.in);
		
		//1) Day[] week; 수요일이면 week 배열에 어떻게 3번을 연결할 것인지
		
	}
	
	private void makeSchedule() {
		System.out.println("===등록===");
		System.out.print("요일 입력 >>> ");      
		String dayName=sc.next().substring(0,1); //4)substring : 만약 사용자가 '월'이 아닌 "월요일"이라고 입력해도 '월'만 쓴다
		sc.nextLine();
		for(int i =0; i<week.length;i++) {    
			if(dayName.equals(dayNames[i])) { // 3)i값으로 연결 수요일의 요일번호는 3이다
				if(week[i]==null) { //week[i]에 스케줄을 넣어야 함, week에 등록된 스케줄이 없으면
					System.out.println("스케쥴 입력>>>");
					String schedule=sc.nextLine(); //스케줄에 공백 입력 가능
					Day day =new Day();
					day.setSchedule(schedule);
					week[i]=day;
					System.out.println(dayName+"요일에 스케쥴이 등록되었습니다.");
				}else {
					System.out.println(dayName+"요일은 이미 스케쥴이 있습니다.");
				}
				return; //리턴 만나면 메소드 끝나니까 if-else 끝난뒤에 넣어서 마쳐야한다
			}		
	   }
		System.out.println(dayName+"요일은 없는 요일입니다."); //5)사용자가 없는 요일을 입력했을 경우
  }
 
	
	private void changeSchedule() {
		System.out.println("===수정===");
		System.out.println("변경할 요일 입력 >>> ");
		String dayName=sc.next().substring(0,1);
		sc.nextLine();
		for(int i=0;i<week.length;i++) {
			if(dayName.equals(dayNames[i])) {
				if(week[i] == null) {
					System.out.println(dayName+"요일은 스케쥴이 없습니다.");
					System.out.println("새 스케쥴을 등록할까요?(y/n) >>>");
					String yesNo=sc.next().substring(0,1);
					sc.nextLine();
					if(yesNo.equalsIgnoreCase("y")) {
						System.out.println("새 스케쥴 입력 >>>");
						String schedule=sc.nextLine();
						Day day=new Day();
						day.setSchedule(schedule);
						week[i]=day;
						System.out.println(dayName+"요일에 새 스케쥴이 등록되었습니다.");
					}else {	
						System.out.println("스케쥴 변경이 취소되었습니다.");
					}	
					}else {	
					System.out.println(dayName+"요일의 스케쥴은"+week[i].getSchedule()+"입니다");
					System.out.println("변경할까요?(y/n)");
					String yesNo=sc.next().substring(0,1);
					sc.nextLine();
					if(yesNo.equalsIgnoreCase("y")) {
						System.out.println("변경할 스케쥴 입력 >>> ");
						String schedule=sc.nextLine();
						week[i].setSchedule(schedule);
						System.out.println(dayName + "요일의 스케쥴이 변경되었습니다.");
					}else {
							System.out.println("스케쥴 변경이 취소되었습니다.");				
				}
					return;
			}
		}
	  }	
		System.out.println(dayName+"요일은 없는 요일입니다.");
	}
	
	private void deleteSchedule() {
		System.out.println("===삭제===");
		System.out.println("삭제할 요일 입력 >>> ");
		String dayName=sc.next().substring(0,1);
		sc.nextLine();
		for(int i=0;i<week.length;i++) {
			if(dayName.equals(dayNames[i])) {
				if(week[i]==null) {
					System.out.println(dayName+"요일은 스케쥴이 없습니다.");
				}else {
					System.out.println(dayName+"요일의 스케쥴은"+week[i].getSchedule()+"입니다.");
					System.out.println("삭제할까요?(y/n) >>> ");
					String yesNo=sc.next().substring(0,1);
					sc.nextLine();
					if(yesNo.equalsIgnoreCase("y")) {
						week[i]=null;
						System.out.println(dayName+"요일의 스케쥴이 취소되었습니다.");
					}else {
						System.out.println("스케쥴 삭제가 취소되었습니다.");
					}
					
				}
				return;
				
			}
		}
		System.out.println(dayName+"요일은 없는 요일입니다.");
		
		
		
	}
	private void printWeekSchedule() {
		System.out.println("===전체조회===");
		System.out.println(nthWeek+"주차 스케쥴 안내");
		for(int i=0; i<week.length;i++) {
			System.out.println(dayNames[i]+"요일-");
			System.out.println(week[i]==null?"X":week[i].getSchedule());
			
		}
	}
	
	public void manage() {
		
		
		while(true) {
			
			System.out.print("1.등록 2.수정 3.삭제 4.전체조회 0.종료 >>> ");
			int choice =sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 : makeSchedule(); break;
			case 2 : changeSchedule(); break;
			case 3 : deleteSchedule(); break;
			case 4 : printWeekSchedule(); break;
			case 0 : System.out.println("스케쥴러를 종료합니다."); return;
			default:System.out.println("인식할 수 없는 명령입니다.");
			
	
		}
		
	  }
	}
}

