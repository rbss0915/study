package com.yedam.java.ch1201;

public class PrintThread extends Thread {
	@Override
	public void run() {
		
		//1.작업중 일시적인 추가작업이 필요한 경우
		while(true) {
			System.out.println("실행중");
			try {
			Thread.sleep(1000);
			}catch(InterruptedException e) {
			System.out.println("interrupt method 실행");
			}
		}
			
			
		//2.interrupt이용해 작업 스레드를 종료시킬 경우
		try {			//try catch가 밖으로 while 감싼형태. while밖이면 인터럽트 안걸림.
			while(true) {
				System.out.println("실행중");
				Thread.sleep(1000);//없으면 인터럽트 오류남
			}
		}catch(InterruptedException e) {
			System.out.println("interrupt method 실행");
			
		}
		System.out.println("자원 정리");
		System.out.println("종료");
	}

	
	
	
	
	
	
	
	
	
	
	
}
