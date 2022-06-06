package homework;

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
     // 4-1 max제품정보
      public Product getMaxPriceInfo() {
    	  Product maxInfo = list[0];
    	  for(int i=1; i<=index; i++) {
    		  if(maxInfo.getPrice() < list[i].getPrice());
    		  maxInfo = list[i];
    	  }
		return maxInfo;
      }
      // 4-2 max제외 가격총합
      public int getTotalPrice() {
    	  int sum = 0;
    	  for(Product temp : list) {
    		  sum += temp.getPrice();
    	  }
    	  Product maxInfo = getMaxPriceInfo();
    	  int result = sum - maxInfo.getPrice();
    	  //int result = sum - getMaxPriceInfo().getPrice();
    	  result = 0;
    	  for(Product temp : list) {
    		  if(temp.getPrice() == maxInfo.getPrice())
    			  continue;
    		  result += temp.getPrice();
    		  /*if(temp.getPrice() < maxInfo.getPrice()){
    		   * result += temp.getPrice();
    		   */
    		  
    	  }
    	  return result;
      }
         
           
      

}