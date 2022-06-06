package homework0603;

import java.util.Scanner;

public class RandomGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Keypad game = null;
		game = new RPGGame();
		game = new AcadeGame();
		
		System.out.println("################ RANDOM ################");
		System.out.println("| RPG GAME | or | ACADE GAME |");
		double randValue = Math.random();
		int randNum = (int)(randValue *2)+1;
		while(true) {
			if(randNum == 1) {
				System.out.println("============");
				System.out.println("| RPG GAME |");
				System.out.println("===============================================================================================");
				System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
				System.out.println("===============================================================================================");
				System.out.println("choice>> ");
				int num = Integer.parseInt(sc.nextLine());
				if(num == 1) {
					game.leftUpButton();
				}else if(num == 2) {
					game.leftDownButton();
				}else if(num == 3) {
					game.rightUpButton();
				}else if(num == 4 ) {
					game.rightDownButton();
				}else if(num == 5) {
					game.changeMode();
				}else if(num == 0) {
					randNum=2;
					continue;
				}else if(num == 9) {
					System.out.println("########GAME END#########");
					System.out.println("########Good Bye#########");
					break;
				}
			}else if(randNum == 2) {
				System.out.println("==============");
				System.out.println("| ACADE GAME |");
				System.out.println("===============================================================================================");
				System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
				System.out.println("===============================================================================================");
				System.out.println("choice>> ");
				int num = Integer.parseInt(sc.nextLine());
				if(num == 1) {
				game.leftUpButton();
				}else if(num == 2) {
					game.leftDownButton();
				}else if(num == 3) {
					game.rightUpButton();
				}else if(num == 4 ) {
					game.rightDownButton();
				}else if(num == 5) {
					game.changeMode();
				}else if(num == 0) {
					randNum=1;
					continue;
				}else if(num == 9) {
					System.out.println("########GAME END#########");
					System.out.println("########Good Bye#########");
					break;
				}
			}
		}	

	}

}
