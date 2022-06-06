package com.yedam.java.ch0604;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		boolean run =true;
		Scanner sc = new Scanner(System.in);
		Calculator calculator = new Calculator();
		
		while(run) {
			System.out.println("1.갯수//2.숫자//3.더하기//4.빼기//5.곱하기//6.나누기//7.종료");
			System.out.println("입력:");
			int select = Integer.parseInt(sc.nextLine());

			//1.갯수 입력
			if(select == 1) {
				System.out.println("갯수");
				int size = Integer.parseInt(sc.nextLine());
				calculator.setArraySize(size);
			}
			//2.숫자 입력
			else if(select == 2) {
				System.out.println("숫자");
				int num = Integer.parseInt(sc.nextLine());
				calculator.setNum(num);
			}
			//3.더하기
			else if(select == 3) {
				calculator.plus();
			}
			//4.빼기
			else if(select == 4) {
				calculator.minus();
			}
			//5.곱
			else if(select == 5) {
				calculator.multi();
			}
			//6.나누기
			else if(select == 6) {
				calculator.divid();
			//7.종료
			}else {
				System.out.println("종료");
				break;
			}
			//0.조건



		}
		
	}

}
