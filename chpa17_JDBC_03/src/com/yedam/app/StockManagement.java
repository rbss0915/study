package com.yedam.app;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.yedam.app.common.Info;
import com.yedam.app.product.Product;
import com.yedam.app.product.ProductDAO;
import com.yedam.java.history.History;
import com.yedam.java.history.HistoryDAO;

public class StockManagement {
	private Scanner sc = new Scanner(System.in);
	private ProductDAO pDao = ProductDAO.getInstance();
	private HistoryDAO hDao = HistoryDAO.getInstance();
	
	public StockManagement() {
		while(true) {
			//메뉴출력
			menuPrint();
			//메뉴입력
			int menuNo = selectMenu();
			//각 기능별 실행
			if(menuNo == 1) {
				//제품동록
				inputProduct();
			}else if(menuNo == 2) {
				//제품입고
				productIn();
			}else if(menuNo == 3) {
				//제품출고
				productOut();
			}else if(menuNo == 4) {
				//제품재고
				productStock();
			}else if(menuNo == 5) {
				//전체재고
				allProductStock();
			}else if(menuNo == 9) {
				//종료
				exit();
				break;
			}else {
				//입력오류
				showInputError();
			}
			
		}
	}
	
	private void menuPrint() {
		System.out.println("============================================================");
		System.out.println(" 1.제품등록 | 2.제품입고 | 3.제품출고 | 4.제품재고 | 5.전체재고 | 9.종료 ");
		System.out.println("============================================================");
	}
	
	private int selectMenu() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자로 입력하세요");
		}
		
		return menu;
	}
	
	private void exit() {
		System.out.println("프로그램 종료");
	}

	private void showInputError() {
		System.out.println("입력 오류 - 메뉴 참고");
	}
	
	private void inputProduct() {
		//제품 정보 입력
		Product product = inputAll();
		//DB에 저장
		pDao.insert(product);
	}
	
	private void productIn() {
		//입고할 제품과 수량 입력
		Info info = inputAmount();
		//기존에 등록된 제품인지 확인
		Product product = pDao.selectOne(info.getProductName());
		
		if(product != null) {
			//-1 기존에 등록된 제품일 경우 입고처리
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductCategory(1);
			history.setProductAmount(info.getProductAmount());
			
			hDao.insert(history);
		}else {
			//-2 기존에 등록되지 않은 경우 별도 안내
			System.out.println("해당 제품의 정보를 우선 등록해주세요");
		}
	}
	
	private void productOut() {
		//출고할 제품과 수량을 입력
		Info info = inputAmount();
		//등록되어있는 제품인지 확인
		Product product = pDao.selectOne(info.getProductName());
		if(product == null) {
			System.out.println("해당 제품의 정보를 확인하세요");
			return;
		}
		//재고량이 있는지 확인
		int stock = selectStock(product.getProductId());
		//재고량과 출고량을 비교
		if(stock >= info.getProductAmount()) {
			//-1 조건을 모두 만족하는 경우 출고처리
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductCategory(2);
			history.setProductAmount(info.getProductAmount());
			
			hDao.insert(history);
		}else {
			//-2 각 조건이 만족되지 않는 경우 적합한 문구를 출력
			System.out.println("재고량이 출고량보다 많습니다");
		}
	}
	
	private void productStock() {
		//검색하고자 하는 제품 정보 입력
		String productName = inputName();
		//등록된 제품인지 확인
		Product product = pDao.selectOne(productName);
		
		if(product == null) {
			System.out.println("해당 제품의 정보가 등록되지 않음");
			return;
		}
		//해당 제품의 재고 출력
		int stock = selectStock(product.getProductId());
		
		System.out.println("제품번호 : " + product.getProductId()
						+ ", 제품이름 : " + product.getProductName()
						+ ", 재고 : " + stock);
	}
	
	private void allProductStock() {
		Map<Integer, Integer> list = hDao.selectAllAmount();
		Set<Integer> productList = list.keySet();
		for(int productId : productList) {
			Product product = pDao.selectOne(productId);
			int stock = list.get(productId);
			
			System.out.println("제품번호 : " + product.getProductId()
			+ ", 제품이름 : " + product.getProductName()
			+ ", 재고 : " + stock);
		}
	}
	
	private Product inputAll() {
		Product product = new Product();
		System.out.println("제품이름>");
		product.setProductName(sc.nextLine());
		System.out.println("제품가격");
		product.setProductId(Integer.parseInt(sc.nextLine()));
		return product;
	}
	
	private Info inputAmount() {
		Info info = new Info();
		System.out.println("제품이름>");
		info.setProductName(sc.nextLine());
		System.out.println("제품수량>");
		info.setProductAmount(Integer.parseInt(sc.nextLine()));
		return info;
	}
	
	private String inputName() {
		System.out.println("제품이름>");
		return sc.nextLine();
	}
	
	private int selectStock(int productId) {
		int in = hDao.selectInAmount(productId);
		int out = hDao.selectOutAmount(productId);
		return (in - out);
	}
	
	
	
	
}
