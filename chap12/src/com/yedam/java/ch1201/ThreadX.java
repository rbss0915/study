package com.yedam.java.ch1201;

public class ThreadX extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	@Override
	public void run() {
		while(!stop) {
			System.out.println("실행중");
		}
		System.out.println("자원 정리");
		System.out.println("종료");
	
	}

}
