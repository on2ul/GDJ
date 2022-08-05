package ex05_throws;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParkingLot {
	
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	
	public ParkingLot() {
		cars= new Car[10];
		sc=new Scanner(System.in);
				
	}
	
	
	
	public void addCar() throws RuntimeException {
	
		if(idx==cars.length) { //addCar에서 예외가 발생하는 경우는 자리가 꽉 찼을 때.
			throw new RuntimeException("FULL");
		
}
			
	}
	
	
	public void deleteCar() throws RuntimeException {
			if(idx==0) {
			throw new RuntimeException("EMPTY");
		}
	
	}	
	
		
	

	public void findCar()throws RuntimeException {
		
	}
	
	public void printAllCars() throws RuntimeException  {
		if(idx==0) {
			throw new RuntimeException("EMPTY");
		
		}
	}
	
	
	public void manage() {
		
	while(true) {	
	  try {	
				System.out.println("1.추가 2.제거 3.조회 4.전체목록 0.종료 >>>");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:addCar();break;
				case 2:deleteCar();break;
				case 3:findCar();break;
				case 4:printAllCars();break;
				case 0:return;
				default:throw new RuntimeException("Bad Request");

			
			}
	  }catch(InputMismatchException e) {
		  sc.next();
		  System.out.println("처리 명령은 정수 1~4,0입니다.");
			
	  }catch(RuntimeException e) {
		  System.out.println(e.getMessage());	  	
	}
	}
	  
}
	
	
	public static void main(String[] args) {
		new ParkingLot().manage();
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
