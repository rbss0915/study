package homework;

import java.util.Scanner;

public class MainProgram {
	private Scanner sc = new Scanner(System.in);
	private BookAccess dao = BookRepo.getInstance();	
	private Program pro = new BookSystem();
	
	public MainProgram() {
		while(true) {
			pro.menuPrint();
			
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				pro.inputInfo(dao);
			}else if(menuNo == 2) {
				pro.printAllInfo(dao);
				
			}else if(menuNo == 3) {
				pro.printInfo(dao);
				
			}else if(menuNo == 4) {
				pro.printRepot(dao);
				
			}else if(menuNo == 5) {
				exit();
				break;
				
			}else {
				
			}
		}
	}
	
	private int menuSelect() {
		System.out.println("선택 :");
		return Integer.parseInt(sc.nextLine());
	}
	
	private void exit() {
		System.out.println("프로그램 종료");
	}

}
