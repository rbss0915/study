package chap01;

import java.util.Scanner;

public class 과제3 {   ///삼각형 면적임. 파일명땜에

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("밑변:");
		double w = Double.parseDouble(scan.nextLine());
		
		System.out.println("높이:");
		double h = Double.parseDouble(scan.nextLine());
	
		double area = (w * h) /2 ;	
		
		System.out.println("면적:" + area);
		
	    System.out.printf("\n밑변: %.2f \n높이: %.2f \n면적: %.2f", w,h,area);

		
	}

}