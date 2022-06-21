package com.yedam.app.common;

import java.util.Scanner;

import com.yedam.app.deal.ReceivingGoodsDAO;
import com.yedam.app.out.TakeOutGoodsDAO;
import com.yedam.app.products.ProductInfoManagement;
import com.yedam.app.products.ProductsDAO;

public class Management {
	//필드
	protected Scanner sc = new Scanner(System.in);		//상속될수 있으니 protected
	protected ProductsDAO pDAO = ProductsDAO.getInstance();
	protected ReceivingGoodsDAO rDAO = ReceivingGoodsDAO.getInstance();
	protected TakeOutGoodsDAO tDAO = TakeOutGoodsDAO.getInstance();
		
	//생성자	-> 	run		생성자 말고 메소드로
	//public Management() {		무한루프
	public void run() {
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				//제품정보관리
				new ProductInfoManagement();
			}else if(menuNo == 2) {
				//제품관리
				new ProductStockManagement();
			}else if(menuNo == 9) {
				//프로그램종료
				exit();
				break;
			}else {
				//입력오류
				showInputError();
			}
		}
	}
	
	//메소드
	protected void menuPrint() {
		System.out.println("============================");
		System.out.println("1.제품정보관리 2.제품재고관리 9.종료");
		System.out.println("============================");
	}
	
	protected int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Insert Number Again");
		}
		return menuNo;
	}
	
	protected void exit() {
		System.out.println("프로그램 종료");
	}
	
	protected void showInputError() {
		System.out.println("Insert Menu");
	}
	

}
