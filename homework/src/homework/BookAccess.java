package homework;

public interface BookAccess {
	//등록
	public void insert(Book book);
	//수정
	public void update(Book book);
	//삭제
	public void delete(int book);
	//전체조회
	public Book[] selcetAll();
	//단건조회
	public Book selcetOne(int BookIsbn);
}
