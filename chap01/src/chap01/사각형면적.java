package chap01;

import java.util.Scanner;

public class 사각형면적 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("가로입력:");
		int w = Integer.parseInt(scan.nextLine());		//가로 입력
		
		System.out.println("세로입력:");
		int h = Integer.parseInt(scan.nextLine());		//세로 입력
	
		int area = w * h;		//가로와 세로의 곱한 면적 area 변수에 저장
		
		System.out.println("면적=" + area);	//면적 출력
		
	}

}
