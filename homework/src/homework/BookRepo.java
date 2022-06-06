package homework;

public class BookRepo implements BookAccess {
	
	private static BookRepo instance = new BookRepo();
	private  BookRepo(){
		init();
	}
	
	public static BookRepo getInstance() {
		return instance;
	}
	
	private Book[] dataList;
	private int listIndex;
	
	private void init() {
		dataList = new Book[100];
		listIndex = -1;
	}
	
	
	@Override
	public void insert(Book book) {
		dataList[++listIndex] = book;
		
	}

	@Override
	public void update(Book book) {
		for (int i = 0; i <= listIndex; i++) {
			if(dataList[i].getIsbn() == book.getIsbn()) {
				dataList[i] = book;
			}
		}
	}
	@Override
	public void delete(int bookIsbn) {
		for (int i = 0; i <=listIndex; i++) {
			if(dataList[i].getIsbn() == bookIsbn) {
				dataList[i] = null;
			}
		}
		cleanDataList();
	}
	private void cleanDataList() {
		//기존데이터 ->임시변수
		Book[] tempList = dataList;
		int tempIndex = listIndex;
		
		//기존필드 초기화
		init();
		
		//임시변수에 데이터만 기존 필드로 복사
		for (int i = 0; i <= tempIndex; i++) {
			if(tempList[i] != null) {
				dataList[++listIndex] = tempList[i];
			}
		}
		
	}
	
	@Override
	public Book[] selcetAll() {
		Book[] list = new Book[listIndex+1];
		for(int i=0; i<list.length; i++) {
			list[i] = dataList[i];
		}
		return list;
	}

	@Override
	public Book selcetOne(int bookIsbn) {
		Book selected = null;
		for(int i = 0; i<= listIndex; i++) {
			if(dataList[i].getIsbn() == bookIsbn) {
				selected = dataList[i];
			}
		}
		return selected;
	}

	

}
