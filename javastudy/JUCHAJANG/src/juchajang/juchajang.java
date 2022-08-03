package juchajang;

import java.util.Scanner;

public class juchajang {
	
	private Scanner sc;
	private Car[] cars;
	private int idx;

	public juchajang() {
		sc=new Scanner(System.in);
		cars=new Car[100];
		
	}
	
	private void addCar() {
		if(idx==cars.length) {
			System.out.println("더 이상 주차할 수 없습니다.");
		}
		System.out.println("===차 등록===");
		System.out.println("차 번호 입력 >>>");
		String carNo =sc.next();
		System.out.println("성명 입력 >>>");
		String type=sc.next();
		Car car=new Car(idx+1, carNo, type);
		cars[idx++]=car;
	
	}
	
	private void removeCar() {
		if(idx==0) {
			System.out.println("등록된 차량이 한 대도 없습니다.");
			return;
		}
		System.out.println("===차량 삭제===");
		System.out.println();
		for(int i=0;i<idx;i++) {
			if(cars[i].getCarNo() == carNo) {
				System.out.println();
			}
		}
	}
	
}
