package homework;

public class Book {
	private int isbn;
	private String name;
	private int price;
	
	public Book() {}
	public Book(int isbn, String name, int price) {
		this.name =name;
		this.price = price;
		this.isbn = isbn;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void getPrice(int price) {
		this.price = price;
	}

	public void showInfo() {
		System.out.println("ISBN : " + isbn + ", 도서명 : " + name + ", 가격 : " + price);
		
	}
	

}
