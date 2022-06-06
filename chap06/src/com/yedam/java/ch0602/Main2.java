package com.yedam.java.ch0602;

public class Main2 {

	public static void main(String[] args) {
		//Car myCar = new Car();  //기본생성자 디폴트로 생성됨, but 생성자 따로만들고 기본생성자 친거 주석처리하면 몬잡음.
		
		Car myCar = new Car("Blue");  //기본생성자 디폴트로 생성됨, but 생성자 따로만들고 기본생성자 친거 주석처리하면 몬잡음.
		
		Car yourCar = new Car("티볼리", "Silver");

		Car newCar = new Car("티볼리", "Silver", 120);
		
		System.out.println(myCar.model);
		System.out.println(myCar.color);
		System.out.println(myCar.maxSpeed);
	}

}
