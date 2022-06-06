package homework;

import java.util.Scanner;

public class ProductTest {

   public static void main(String[] args) {
	  boolean run = true;
      Scanner sc = new Scanner(System.in);
      ProductSystem system = new ProductSystem();
      
      while(run) {
         System.out.println("메뉴를 선택하세요");
         System.out.println("1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료" );
         System.out.println("입력: ");
         int selectNo = Integer.parseInt(sc.nextLine());
         
         if(selectNo == 1) {
            System.out.println("1.상품 수 : ");
            int count = Integer.parseInt(sc.nextLine());
            System.out.println(count);
         }
         else if(selectNo ==2) {
            System.out.println("2.상품 : ");
            String name = sc.nextLine();
            System.out.println("2.가격 : ");
            int price = Integer.parseInt(sc.nextLine());
            system.putProduct(name, price);
         }
         else if(selectNo ==3) {
            system.printList();
         }
         else if(selectNo ==4) {
        	Product maxInfo = system.getMaxPriceInfo();
            System.out.println("4.분석");
            System.out.println("총합:" + maxInfo.getName());
            System.out.println("max제외 평균 : " + system.getTotalPrice());
         }
         else if(selectNo == 5) {
            run = false;
            System.out.println("5.프로그램을 종료");
         }
         else
            System.out.println("메뉴를 다시 선택하세요.");
         }
      } 
}