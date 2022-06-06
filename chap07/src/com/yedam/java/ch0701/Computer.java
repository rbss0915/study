package com.yedam.java.ch0701;

public class Computer extends Calculator{
	
	@Override  //->자바한테 알려주는거 . 관례
	double areaCircle(double r) { //누구껀지 구분안됨
		System.out.println("부모 :" + super.areaCircle(r));
		System.out.println("Computer 객체");
		return Math.PI*r*r;
	}
	
	void print() {
		super.areaCircle(5);
		areaCircle(5);
	}

}
