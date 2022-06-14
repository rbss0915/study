package com.yedam.java.ch1201;

public class User extends Thread {
	private static int serial = 0;
	private Calculator cal;
	private int numInfo;
	
	public void setCalculater(Calculator cal) {
		serial+=100;
		this.setName("User" + serial);		//내부에서 스레드에 이름지정
		this.cal= cal;
		this.numInfo = serial;
	}
	
	@Override
	public void run() {
		cal.setMemory(100 + serial);
	}

}
