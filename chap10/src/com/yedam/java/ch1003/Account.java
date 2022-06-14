package com.yedam.java.ch1003;

public class Account {
	private long balance;
	
	public long getBalance() {
		return balance;
	}

	public void deposit(int money) {
		balance += money;
	}
	
	public long withDraw(int money) throws BalaceInsufficientException{
		if( balance < money	) {
			throw new BalaceInsufficientException("잔고부족 : "		//throw
						+ (money - balance) + " 모자랍니다.");
						
		}
		
		balance -= money;
		return balance;
	}
}
