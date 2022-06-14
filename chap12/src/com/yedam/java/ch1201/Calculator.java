package com.yedam.java.ch1201;

public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	public synchronized void setMemory(int memory) {		//synchronized없으면 여러군데 동시에 실행되면 필드값이 제대로된다는 보장이 없음
		this.memory = memory;
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {}
		Thread info = Thread.currentThread();
		System.out.println("현재 스레드 : " + info.getName() + ", memory" + this.memory);
			
		
	}

}
