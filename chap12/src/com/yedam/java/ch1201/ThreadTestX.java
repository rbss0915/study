package com.yedam.java.ch1201;

public class ThreadTestX {

	public static void main(String[] args) {
		ThreadX thread = new ThreadX();
		thread.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread.setStop(true);		//2초간 실행하다 스탑함.
		
		System.out.println("----------------------------");
		
		Thread sub = new Thread() {
			@Override
			public void run() {
				while(true) {
					if(Thread.interrupted())
						break;
					System.out.println("=====실행 중");
				}
				System.out.println("=====자원 정리");
				System.out.println("=====종료");
			}
		};
		
		sub.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sub.interrupt();

	}

}
