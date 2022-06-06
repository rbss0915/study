package com.yedam.java.ch0702;

public class ChildTest2 {
	public static void main(String[] args) {
		GranPa pa = new Father();
		pa.method();
		//pa = new Uncle();			//1낑겼는데 문법상오류없는이유-pa->GranaPa연결되있어서 but 돌리면 오류뜸
		
		System.out.println();
		if(pa instanceof Father) {	//2이거 넣줌
		Father fa = (Father) pa;
		fa.method();
		fa.method2();
		}else {
			System.out.println("pa 변수가 가지고 있는 인스턴스는 Father이 아닙니다.");
		}
	}

}
