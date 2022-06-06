package 과제제출;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class 숫자맞추기 {

	public static void main(String[] args){
		game();
		regame();
	}

	public static void game(){
		Scanner scan = new Scanner(System.in);
		Random rd = new Random();
				
		int rand = rd.nextInt(99) + 1;
		int num;
		for(int i=0; i<10;i++) {
			System.out.println("Life : "+ i + "/10");
			System.out.println("Select your number");
			num = scan.nextInt();
			
			if(rand > num) {
				System.out.println(num);
				System.out.println("####### Up #######");
			}
			else if(rand < num) {
				System.out.println(num);
				System.out.println("###### Down ######");
			}
			else{
				System.out.println("########" + rand + "#######");
				System.out.println("Congratulations!");
				System.out.println("########" + rand + "#######");
				System.out.println("Try again? (1.Yes/2.No)");
				//break;
				regame();
				break;
			}
			if(i>10) {
				System.out.println("You die");
				System.out.println("correct answer : " + rand);
				System.out.println("Try again? (1.Yes/2.No)");
				//break;
				regame();
				break;
			}
		}
		
		
	}
	
	public static void regame() {
		Scanner scan = new Scanner(System.in);
		int yes = 1;
		int no = 2;
		int re;
		re = scan.nextInt();
		while(true){
			if(re == yes) {
				game();
				break;
			}
			else if (re == no){
				System.out.println("Good Bye");
				System.exit(0);
			}
			else {
				System.out.println("selct number 1 or 2");
				regame();
			}
		}

	}

}