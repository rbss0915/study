package com.yedam.java.ch0605;

public class CarTest {

	public static void main(String[] args) {
		//CarTest ct = new CarTest();	// new연산자 땜에 밑에 보이드프린트 가능
		//ct.print();
		//print();
		
		Car myCar = new Car("포르쉐");
		Car yourCar = new Car("벤츠");
		
		myCar.run();
		System.out.println();
		yourCar.run();

	}

	public void print() {
		System.out.println("print");
		
	}
}
