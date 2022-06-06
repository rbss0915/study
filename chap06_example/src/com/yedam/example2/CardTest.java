package com.yedam.example2;

public class CardTest {

	public static void main(String[] args) {
		CardFactory factory = CardFactory.getInstance();
		
		Card first = factory.createCard();
		Card second = factory.createCard();
		Card third = factory.createCard();
		System.out.println("first:" + first.getSerialNum());

	}

}
