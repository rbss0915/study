package com.yedam.java.ch0602;

public class Main {

	public static void main(String[] args) {

		Car myCar = new Car();
		System.out.println(myCar.company);
		System.out.println(myCar.model);
		System.out.println(myCar.color);
		System.out.println(myCar.maxSpeed);
		myCar.speed = 100;
		System.out.println(myCar.speed);
		
		Car yourCar = new Car();
		System.out.println(yourCar.company);
		System.out.println(yourCar.model);
		System.out.println(yourCar.color);
		System.out.println(yourCar.maxSpeed);
		System.out.println(yourCar.speed);
		
		Car blueCar = new Car("Blue");
		System.out.println(blueCar.color); //Car클래스의 This에 걸림..생성자는 필드 안건드림
		
		Car newCar = new Car();
		System.out.println(newCar.color);
		
	}

}
