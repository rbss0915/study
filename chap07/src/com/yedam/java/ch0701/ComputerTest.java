package com.yedam.java.ch0701;

public class ComputerTest {
	public static void main(String[] argStrings) {
		Calculator cal = new Calculator();
		System.out.println("원 면적: "
							+ cal.areaCircle(10));
	
	
		Computer com = new Computer();
		System.out.println("원 면적 :"
							+com.areaCircle(10));
	
		System.out.println();
		
		com.print();
	}

}
