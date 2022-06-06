package com.yedam.java.example1;

public class VIP extends Customer {
	// 필드
	double saleRatio;// 할인율
	String csName;

	// 생성자
	public VIP(int customerId, String customerName, String name) {
		super(customerId, customerName);
		this.customerGrade = "VIP";
		this.bonusRatio = 0.05;
		this.saleRatio = 0.15;
		this.csName = csName;
	}

	@Override
	public int calcPrice(int price) {
		this.bonusPoint += price * this.bonusRatio;
		return price - (int)(price * bonusRatio);
	}
	@Override
	public String showInfo() {
		return super.showInfo()	+ "\n"
				+ " 담당 상담원은" + csName + "입니다.";
	}

	public double getSaleRatio() {
		return saleRatio;
	}

	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}

	public String getCsName() {
		return csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}


}
