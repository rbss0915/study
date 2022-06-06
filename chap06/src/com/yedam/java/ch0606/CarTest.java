package com.yedam.java.ch0606;

public class CarTest {

	public static void main(String[] args) {
		
		Car myCar = new Car();
		
		myCar.setSpeed(-50);//myCar.speed = -50 ->Car if 검증안하면 -50으로 출력. 0으로출력위해서
		
		System.out.println("현재속도:" + myCar.getSpeed());
		
		myCar.setSpeed(50);
		
		System.out.println("현재속도:" + myCar.getSpeed());
		
		if(!myCar.isStop()) {		// if는 true 띄우는데false 뜨니까 반전
			myCar.setStop(true);
		}
		System.out.println("현재속도:" + myCar.getSpeed());
	}

}
