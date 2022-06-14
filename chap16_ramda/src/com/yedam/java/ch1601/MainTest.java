package com.yedam.java.ch1601;

public class MainTest {
	//람다식
	public static void main(String[] args) {
		MyFunctionalInterface fi = () -> {System.out.println("람다식 실행");};	//인터페이스에 2개이상 메소드있으면 오류뜸.
		fi.method();
		
		//원래 정석방식////////////////
		MyFunctionalInterface mfi = new MyFunctionalInterface() {
			@Override
			public void method() {System.out.println("익명 구현 객체 실행");
			}
		};
		mfi.method();
		//////////////////////////
	}

}
