package com.yedam.java.ch1201;

import java.util.Scanner;

public class PrintThreadTest {

	public static void main(String[] args) {
		//new PrintThread().start();//무한 반복
		
		Thread jobThread = new PrintThread();
		jobThread.start();
		
		System.out.println("프로그램을 종료하시겠습니까?");
		int result = new Scanner(System.in).nextInt();
		
		if(result > 0) {
			jobThread.interrupt();
		}

	}

}
