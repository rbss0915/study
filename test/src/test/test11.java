package test;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class test11 {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int yes = 1;
		int no = 2;
		int re;
		re = scan.nextInt();
		while(true){
			if(re == yes) {
				System.out.println("hi Bye");
				break;
			}
			else if (re == no){
				System.out.println("Good Bye");
				break;
			}
			else {
				System.out.println("selct number 1 or 2");
				break;
			}
		}

	}

}