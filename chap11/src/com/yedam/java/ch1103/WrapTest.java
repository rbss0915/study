package com.yedam.java.ch1103;

public class WrapTest {

	public static void main(String[] args) {
		Integer obj1 = new Integer(100);
		Integer obj2 = Integer.valueOf("100");	//공식적 방법
		Integer obj3 = 100;
		
		int val2 = obj2.intValue(); //공식적 방법
		int val3 = obj3;
		
		int result = obj2 + val3;
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		System.out.println("");
		System.out.println(val2);
		System.out.println(val3);
		System.out.println("");
		System.out.println(result);
		
		//////////////////////////////////////
		
		Integer object1 = 300;
		Integer object2 = 300;
		
		System.out.println("== 결과 : " + (object1 == object2));		//등호연산자 다른인스턴스로 인식,자동언박싱X
		System.out.println("언방싱 후 ==결과 : " + (object1.intValue() == object2.intValue()));
		System.out.println("equls() 결과 : " + object1.equals(object2));
	}

}
