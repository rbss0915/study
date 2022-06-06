package com.yedam.java.ch0605;

public class Planet {
	//필드
	final int radius;		//딱한번 설정
	static final double pi = 3.1459;	//계속고정
	
	//생성자
	Planet(int radius){
		this.radius = radius;
	}
	
	//메소드
	void getArea() {
		double result = 4* Planet.pi *this.radius*this.radius;
		System.out.println("행성의 표면적:" + result);
		
	}

}

