package com.yedam.java.ch0802;

public class Car {
	Tire frontLefetTire = new KumhoTire();
	Tire frontRightTire = new KumhoTire();
	Tire backLefetTire = new KumhoTire();
	Tire backRightTire = new KumhoTire();

	void run() {
		frontLefetTire.roll();
		frontRightTire.roll();
		backLefetTire.roll();
		backRightTire.roll();
	}
}
