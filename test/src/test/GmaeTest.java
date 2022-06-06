package test;

import java.util.Random;
import java.util.Scanner;

public class GmaeTest {

	public static void main(String[] args) {


	 Scanner scan = new Scanner(System.in);
	 Random rd = new Random();
		
		int ans = rd.nextInt(99) + 1; // 1 ~ 100
		int num = scan.nextInt();	
		int count = 1;

		do {
			count++;
			num = scan.nextInt();
			if( ans > num ) {
				System.out.println( "크다");
			}
			else if ( ans < num) {
				System.out.println("작다");
			}
			else if ( ans == num) {
				System.out.println("정답");
			}
			if(count>5) {
				System.out.println("종료");
				break;
			}
			System.out.println(ans);
			
				
		}while(true);
	
	}
}