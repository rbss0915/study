package test;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class gametest1 {

	public static void main(String[] args){
		game();
		regame();
	}

	public static void game(){
		Scanner scan = new Scanner(System.in);
		Random rd = new Random();
				
		int rand = rd.nextInt(99) + 1;
		int num;
		int count = 0;
		
		do {
			count++;
			System.out.println("Life : "+ count + "/10");
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
				//break;
				regame();
			}
			if(count>9) {
				System.out.println("You die");
				System.out.println("correct answer : " + rand);
				//break;
				regame();
			}
		}while(true);
		
		
	}
	
	public static void regame() {
		System.out.println("Try again? (1.Yes/2.No)");
		Scanner scan = new Scanner(System.in);
		int yes = 1;
		int no = 2;
		int re;
		re = scan.nextInt();
		while(true){
			if(re == yes) {
				game();
			}
			else if (re == no){
				System.out.println("Good Bye");
				break;
			}
			else {
				System.out.println("selct number 1 or 2");
			}
		}

	}
}