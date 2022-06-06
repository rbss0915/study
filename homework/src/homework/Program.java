package homework;

public interface Program {
	//메뉴출력
	public void menuPrint();
	//정보 입력
	public void inputInfo(BookAccess access);
	//입력된 전체정보를 출력
	public void printAllInfo(BookAccess access);
	//특정 조건의 정보를 출력
	public void printInfo(BookAccess access);
	//분석
	public void printRepot(BookAccess access);

}
