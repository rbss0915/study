package com.yedam.java.ch0901;

public class MainTest {

	public static void main(String[] args) {
		A a = new A();
		
		System.out.println();
		//인스턴스 멤버 클래스
		A.B b = a.new B();
		b.feild1 = 1;
		b.method1();
		
		//정적 멤버 클래스
		A.C.field2 = 2;
		A.C.method2();
	
		A.C c = new A.C();
		c.field1 = 1;
		c.method1();
		
		//로컬 클래스
		a.method();
		
	}
}
