package array;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		game();

		int x = 0;
		int y = 0;
	}

	public static void game() {
	
		do {
			Scanner scan = new Scanner(System.in);
			
			Random rd = new Random();
			int x = rd.nextInt(99) + 1; // 1 ~ 100
			int y = scan.nextInt();
			
			
		} while(true);
		
		
		
	
	}
	
}
