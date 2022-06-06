package com.yedam.java.example1;

public class Gold extends Customer {
	// 필드
	double saleRatio;// 할인율

	// 생성자
	public Gold(int customerId, String customerName) {
		super(customerId, customerName);
		this.customerGrade = "GOLD";
		this.bonusRatio = 0.02;
		this.saleRatio = 0.1;
	}

	@Override
	public int calcPrice(int price) {
		// 1.보너스 포인트 적립
		this.bonusPoint += price * this.bonusRatio;
		// 2.할인율이 적용된 가격
		return (int) (price * (1 - this.saleRatio));
	}

	public double getSaleRatio() {
		return saleRatio;
	}

	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}

}
