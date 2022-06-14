package com.yedam.java.ch1201;

public class UserTest {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		User user1 = new User();
		user1.setCalculater(cal);
		user1.start();
		//예상200

		User user2 = new User();
		user2.setCalculater(cal);
		user2.start();
		//예상300
		
		//동시에 Calulator 써서 둘다 300나옴
		
			}

}
