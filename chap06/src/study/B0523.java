package study;

import java.util.Scanner;

public class B0523 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		A0523 calculator = new A0523();
		boolean run = true;
		
		while(run) {
			System.out.println(" 1.학생수 | 2.점수 | 3. 전체조회 | 4. 최대 | 5. 최소 | 6. 평균 ");
			System.out.println("선택> ");
			int selectNo = scan.nextInt();
			
			if(selectNo==1) {
				System.out.println("학생수:");
				int size = scan.nextInt();
				calculator.studentN(size);
			} else if(selectNo==2) {
				System.out.println("점수: ");
				int num = scan.nextInt();
				calculator.studentS(num);
			} else if(selectNo==3) {
				calculator.studentAll();
			} else if(selectNo==4) {
				calculator.max();
			} else if(selectNo==5) {
				calculator.min();
			} //else if(selectNo==6) {
				//calculator.multi();}
			 else if(selectNo==7) {
				run = false;
				System.out.println("프로그램 종료");
			}
		}
	}

}
