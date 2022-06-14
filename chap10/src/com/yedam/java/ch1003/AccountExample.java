package com.yedam.java.ch1003;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		
		account.deposit(100000);
		System.out.println("예금액 : " + account.getBalance());
	
		try{
		account.withDraw(3000000);	//오류 처리필요
		} catch(BalaceInsufficientException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	
	}

}
