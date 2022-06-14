package com.yedam.java.ch0901;

public class Outter {
	String field = "바깥클래스 - 필드";
	void method() {
		System.out.println("바깥클래스 - 메소드");
	}
	void methodA() {
		System.out.println("바깥클래스 = 메소드A");
	}
	
	//인스턴스 멤버 클래스
	class Nested{
		String field = "중첩클래스 - 필드";
		void method() {
			System.out.println("중첩클래스 - 메소드");
		}
		
		void print() {
			methodA();	//바깥꺼
			System.out.println(field);	//=this.method, 중첩꺼
			method();	//this.method(); 중첩꺼
			System.out.println(Outter.this.field); //바깥꺼
			Outter.this.method();	//바깥꺼
		}
	}
	
	//중첩 인터페이스
	interface I{			//인스턴스 인터페이스
		int FIELD = 100;
		void method();
	}
	
	static interface N{		//정적 인터페이스
		int FIELD = 100;
		void method();
		
	}

}
