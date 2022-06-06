package homework;


import java.util.Random;
import java.util.Scanner;

public class BookSystem implements Program {
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public void menuPrint() {
		System.out.println("============================================");
		System.out.println("1.도서입력 | 2.도서조회 | 3.검색 | 4.분석 | 5.종료 ");
		System.out.println("============================================");
	}

	@Override
	public void inputInfo(BookAccess access) {
		//사용자가 정보를 입력
		Book info = inputAll();
		//저장소에 등록
		access.insert(info);

	}
	private Book inputAll() {
		System.out.println("도서명 : ");
		String name = sc.nextLine();
		System.out.println("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		int isbn = (int)(Math.random() * (99999 - 10000 + 1)) + 10000;
		System.out.println("ISBN : " + isbn + "[자동 등록]");
		
		return new Book(isbn, name, price);
	
		
	}
	@Override
	public void printAllInfo(BookAccess access) {
		//저장소에서 데이터를 가져옴
		Book[] list = access.selcetAll();
		
		//데이터 전체 출력
		for(Book book : list) {
			book.showInfo();
		}

	}

	@Override
	public void printInfo(BookAccess access) {
		//검색 조건 입력
		int isbn = inputIsbn();
		//저장소에서 검색
		Book info = access.selcetOne(isbn);
		//출력
		info.showInfo();

	}
	
	private int inputIsbn() {
		System.out.println("검색 ISBN : ");
		return Integer.parseInt(sc.nextLine());
	}

	@Override
	public void printRepot(BookAccess access) {
		//최고
		System.out.println("최고가 도서 : ");
		Book maxInfo = selectMaxPrice(access);
		maxInfo.showInfo();
		//최저
		System.out.println("최저가 도서 : ");
		Book minInfo = selectMinPrice(access);
		minInfo.showInfo();
		//평균
		System.out.println("최고,최저가 도서를 제외한 총 가격의 평균 : ");
		double avgResult = calAvg(access);
		System.out.println(avgResult);
	}
	
	private Book selectMaxPrice(BookAccess access) {
		Book[] list = access.selcetAll();
		
		Book maxInfo = list[0];
		for (int i = 1; i < list.length; i++) {
			if(maxInfo.getPrice() < list[i].getPrice()) {
				maxInfo = list[i];
			}
		}
		return maxInfo;
		
	}
	private Book selectMinPrice(BookAccess access) {
		Book[] list = access.selcetAll();
		
		Book minInfo = list[0];
		for (int i = 1; i < list.length; i++) {
			if(minInfo.getPrice() > list[i].getPrice()) {
				minInfo = list[i];
			}
		}
		return minInfo;
		
	}
	
	private double calAvg(BookAccess access) {
		Book[] list = access.selcetAll();
		
		int sum = 0;
		for(Book info : list) {
			sum += info.getPrice();
		}
		return(double)sum/list.length;
		
	}
	
	

}
