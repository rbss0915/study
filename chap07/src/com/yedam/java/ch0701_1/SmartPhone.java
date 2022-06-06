package com.yedam.java.ch0701_1;

import com.yedam.java.ch0701.Phone;

public class SmartPhone extends Phone {
	
	public SmartPhone(String model, String color) {
		super(model, color);
	}

	@Override
	void powerOn() {
		System.out.println("폰동작");
		super.powerOn();
	}

	@Override
	void powerOff() {
		System.out.println("폰종료");
		super.powerOff();
	}

	@Override
	protected void bell() {
		System.out.println("벨소리");
		super.bell();
	}

	@Override
	void call() {
		System.out.println("통화");	//파이널
		super.call();
	}
	
	@Override
	void print() {
		System.out.println("폰종료");  //프라이빗
		super.print();
	}


}
