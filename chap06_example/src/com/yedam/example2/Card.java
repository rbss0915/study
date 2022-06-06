package com.yedam.example2;

public class Card {

	//필드
	private static int serialNum = 1100;
	
	private int cardNo;
	
	//생성자
	public Card() {
		serialNum++;
		cardNo = serialNum;
	}
	//메소드
	public static int getSerialNum() {
		return serialNum;
	}
}
