package home;

import java.util.Scanner;

public class ProductTest {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      boolean run = true;
      ProductSystem Product = new ProductSystem();
      
      while(run) {
         System.out.println("메뉴를 선택하세요");
         System.out.println("1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료" );
         System.out.println("입력: ");
         int selectNo = scan.nextInt();
         
         if(selectNo == 1) {
            System.out.println("1.상품 수 : ");
            int size = scan.nextInt();
            Product.setListSize(size);
            System.out.println();
         }
         else if(selectNo ==2) {
            System.out.println("2.상품 및 가격입력 : ");
            String name = scan.next();
            int price = scan.nextInt();
            Product.putProduct(name, price);
            System.out.println();
         }
         else if(selectNo ==3) {
            System.out.println("3.제품별 가격 :");
            Product.printList();
         }
         else if(selectNo ==4) {
            System.out.println("4.분석");
            System.out.println("총합:");
            System.out.println(Product.analysis());
            System.out.println("max제외 평균 : ");
            System.out.println(Product.total());
         }
         else if(selectNo == 5) {
            run = false;
            System.out.println("5.프로그램을 종료합니다.");
         }
         else
            System.out.println("메뉴를 다시 선택하세요.");
         }
      } 
}