package home;

public class ProductSystem {
      private Product[] list;
      private int index;

      public ProductSystem() {
         index =-1;
      }
      //1.상품 수 입력
      public void setListSize(int size) {
         list = new Product[size];
      }
      //2.상품 및 가격 입력
      public void putProduct(String name, int price) {
         Product product = new Product();
         product.setName(name);
         product.setPrice(price);
         
         list[++index] = product;
      }
      //3.제품별 가격 출력
      public void printList() {
         for(int i=0; i<= index; i++) {
            Product product = list[i];
         //   System.out.println(product.getName() + " : " + product.getPrice());
            System.out.println(list[i].getName() + " : " +list[i].getPrice());
         }
      }
     // 4. 분석
      public int analysis() {
         int max = list[0].getPrice();
         for(int i=0; i < list.length; i++) {
            if(max < list[i].getPrice()) {
               max = list[i].getPrice();
            }
         }
         return max;
      }
      
      int total() {
         int sum = 0;
         int result = 0;
         for(int i=0; i<list.length; i++) {
            sum += list[i].getPrice();
         }
         result = (sum - analysis());
         return result;
      }
         
           
      

}