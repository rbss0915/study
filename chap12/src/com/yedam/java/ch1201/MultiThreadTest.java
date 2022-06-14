package com.yedam.java.ch1201;

public class MultiThreadTest {

	public static void main(String[] args) {
		Thread main = Thread.currentThread();// currentThread는 Thread클래스에 진행되는 내용을 가져옴
		System.out.println("메인 스레드 : " + main.getName());
		System.out.println("");
		
		//Runnable a = new ThreadA();
		//Thread thread = new Thread(a);
		Thread thread = new ThreadB();
		thread.setName("threadA");//원하는 이름으로 바꿈
		System.out.println("작업 스레드 : " + thread.getName());	//스레드안에 겟네임이란게지정되있음
		thread.start();
		
		for (int i = 0; i <= 5; i++) {
			System.out.println(i + "번째 출력");
			try {
			Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	
}
