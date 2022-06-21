package com.yedam.app.products;

import com.yedam.app.common.Management;

public class ProductStockManagement extends Management{
	
	public ProductStockManagement() {
		while(true) {
			menuPrint();
			
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				
			}else if(menuNo == 2) {
			}else if(menuNo == 3) {
				//제품정보삭제
			}else if(menuNo == 9) {
				//뒤로가기
				break;
			}else {
				//입력오류
				showInputError();
				
			}
		}
	}

}
