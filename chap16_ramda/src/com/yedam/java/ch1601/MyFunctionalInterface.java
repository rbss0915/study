package com.yedam.java.ch1601;

@FunctionalInterface	//메소드하나만 갖게 제한검
public interface MyFunctionalInterface {		//람다 전제조건:하나의 메소드만 포함해야함
	public void method();
	//public void otherMethod(); 화살표에서 오류

}
