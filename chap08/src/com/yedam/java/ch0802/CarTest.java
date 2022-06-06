package com.yedam.java.ch0802;

public class CarTest {

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		
		System.out.println();
		
		myCar.frontLefetTire = new HankookTire();
		myCar.frontRightTire = new HankookTire();
		
		myCar.run();
		

	}

}
