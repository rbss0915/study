package com.yedam.java.ch0605;

public class SingletonTest {

	public static void main(String[] args) {
		//Singleton obj1 = new Singleton(); 오류남
		
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("같은 singleton 객체입니다");
		}else {
			System.out.println("다른 singleton 객체입니다");
		}

	}

}
