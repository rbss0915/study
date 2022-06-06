package com.yedam.example;

public class Subway {
	//필드
	private String subwayNumber;
	private int money;
	private int passengerCount;
	private int pay;
	
	//생성자
	public Subway(String lineNumber, int pay) {
		this.subwayNumber = subwayNumber;
		this.pay += pay;
	}
	//메서드
	public int getPay() {
		return pay;
	}
	
	public void take(int money) {
		this.money += money;
		this.passengerCount++;
	}
		
	public void showInfo() {
		System.out.println(subwayNumber + "의 승객은");
		System.out.println(passengerCount + "명이고, 수입은");
		System.out.println(money + "원 입니다.");
	}
		
	
}
