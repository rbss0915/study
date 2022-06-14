package com.yedam.java.ch1502;

public class MainTest {

	public static void main(String[] args) {
		int result1 = Util.<String>compare("홍", "김");//오류남 - 넘버만 상속해서

		int result2 = Util.compare(1, 10);
		
		int result3 = Util.compare(0.5, 5.9);
	}

}
