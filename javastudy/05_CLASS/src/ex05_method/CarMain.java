package ex05_method;

public class CarMain {

	public static void main(String[] args) {
		
		// 객체 생성
		
		Car car=new Car();
		
		car.addOil(10);
		car.addOil(10);
		car.addOil(40);
		
		car.pushAccel();
		car.pushAccel();
		
		car.pushBreak();
		
		car.panel();

	}

}
