package com.yedam.java.ch0802;

public class Driver {
	void drive(Vehicle vehicle) {
		//if(vehicle instanceof Bus) {
			Bus bus = (Bus)vehicle;
			bus.checkFare();
		//}
		//if빠져도 문법상 문제없지만 실행시 문제 방지
		vehicle.run();
		
	}

}
