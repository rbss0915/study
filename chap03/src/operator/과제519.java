package operator;

import java.util.Scanner;

public class 과제519 {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      boolean run = true;
      int menu = 0;
      int balance = 0;
      int input = 0;
      int output = 0;

      while (run) {
         
          System.out.println(" ----------------------------- ");
          System.out.println(" 1.예금 | 2.출금 | 3.잔고 | 4.종료 ");
          System.out.println(" ----------------------------- ");
          System.out.println("선택> ");
         
         menu = scan.nextInt();
         if (menu == 1) {
            System.out.println("예금액> ");
          input = scan.nextInt();
          balance += input;

         } else if (menu == 2) {
            System.out.println("출금액> ");
            output = scan.nextInt();
            balance -= output;

         } else if (menu == 3) {
            System.out.println("잔고> ");
            System.out.println(balance);

         } else if (menu == 4) {
            System.out.println("프로그램 종료");
            break;
         }
         
         else {
        	 System.out.println("");
        	 continue;
			
		}
      }
   }
}