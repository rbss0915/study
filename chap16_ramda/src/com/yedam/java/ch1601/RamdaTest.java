package com.yedam.java.ch1601;

public class RamdaTest {

	public static void main(String[] args) {
	//////매개변수도 리턴타입도 없는 람다식A/////////////
		MyFunInterfaceA fa = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		fa.method();
			//표현식2
		fa = () -> {System.out.println("method call2"); };
		fa.method();
		
			//표현식3
		fa = () -> System.out.println("method call3");
		fa.method();
	///////////////////////////////////////////
		System.out.println("");
	//////매개변수가 있고 리턴타입이 없는 람다식B/////////
		MyFunInterfaceB fb = (int x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		fb.method(5);
		
		//표현식2
		fb = (x) -> {System.out.println(x*5);};
		fb.method(6);
		//표현식3
		fb = (x) -> System.out.println(x*5);
		fb.method(7);
	////////////////////////////////////////////	
		System.out.println("");
	//////매개변수가 있고 리턴타입이 있는 람다식C//////////
		MyFunInterfaceC fc = (int x, int y) -> {
			int result = x + y;
			return result;
			
		};
		
		System.out.println(fc.method(1, 2));
		
		//표현식2
		fc = (x, y) -> {return x + y; };
		System.out.println(fc.method(1,5));

		//표현식3
		fc = (x, y) -> x + y;		//리턴생략가능
		System.out.println(fc.method(6,5));
		
		//응용
		fc = (x,y) -> Math.max(x,y);
		System.out.println(fc.method(8, 9));
		/*fc = (x,y) -> {
			int result = Math.max(x,y);
			return result;
		};*/ //생략시킴
	/////////////////////////////////////////////
		
		int val1 = 10;
		int val2 = 20;
		
		fa = () -> {
			int result = val1 + val2;		//외부 변수가질수있지만 이때 변수는 파이널특성을 가짐. 참조주소가아닌 값을 가져옴.
			System.out.println(result);
		};
		
		//val1 = 100;
		fa.method();
		
		
		
		
	}
}
