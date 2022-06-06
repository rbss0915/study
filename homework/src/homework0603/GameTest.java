package homework0603;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Keypad game = null;
		game = new RPGGame();
		game = new AcadeGame();
		
		while(true) {
			System.out.println("################ GAME START ################");
			System.out.println("               | SELECT MODE |              ");
			System.out.println("1 : RPG GAME | 2 : ACADE GAME | 3 : EXIT");
			System.out.println("selct number : ");
			int num = Integer.parseInt(sc.nextLine());
			
			if(num == 1) {
				System.out.println("==================");
				System.out.println("| RPG GAME START |");
				System.out.println("==================");
				while(true) {
					game.leftUpButton();
					game.leftDownButton();
					game.rightUpButton();
					game.rightDownButton();
					game.changeMode();
					System.out.println("1.Chane mode|2.EXIT");
					System.out.println("Slelct number : ");
					int num2 = Integer.parseInt(sc.nextLine());
					if(num2==1) {
						continue;
					}else if(num2==2) {
						break;
					}
				}
			}else if(num == 2) {
				System.out.println("===================");
				System.out.println("| ACADE GAME START|");
				System.out.println("===================");
				while(true) {
					game.leftUpButton();
					game.leftDownButton();
					game.rightUpButton();
					game.rightDownButton();
					game.changeMode();
					System.out.println("1.Chagne mode|2.EXIT");
					System.out.println("Slelct number : ");
					int num2 = Integer.parseInt(sc.nextLine());
					if(num2==1) {
						continue;
					}else if(num2==2) {
						break;
					}
				}
			}else if(num == 3) {
				System.out.println("*******GOOD BYE********");
				break;
			}else {
				System.out.println("START AGAIN");
			}
		}
	}
}
