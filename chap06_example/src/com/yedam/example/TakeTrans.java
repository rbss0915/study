package com.yedam.example;

public class TakeTrans {

	public static void main(String[] args) {
		Student hong = new Student("Hong", 5000);
		Bus green = new Bus("202번", 1500);
		
		hong.take(green);
		
		Subway subway = new Subway("2호선", 1250);
		hong.take(green);
		hong.showInfo();
		green.showInfo();

	}

}
