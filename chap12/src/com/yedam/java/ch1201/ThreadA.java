package com.yedam.java.ch1201;

public class ThreadA implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("현재 순서 :" + i);
			try {
			Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
