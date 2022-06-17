package com.yedam.java.emp;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class DpmtSystem {
	private DpmtDAO dao = DpmtDAO.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	public DpmtSystem() {
		while(true) {
			//메뉴 출력
			menuPrint();
			//메뉴 입력
			int menuNo = selectMenu();
			//각 기능별 실행
			if(menuNo == 1) {
				//등록
				insertDepartment();
			}else if(menuNo == 2) {
				//수정
				updateDepartment();
			}else if(menuNo == 3) {
				//삭제
				deleteDepartment();
			}else if(menuNo == 4) {
				//단건조회
				selectDepartment();
			}else if(menuNo == 5) {
				//전체조회
				selectAllDepartment();
			}else if(menuNo == 9) {
				exit();
				break;
			}else {
				inputError();
			}
		}
	}
	
	private void menuPrint() {
		System.out.println("==================================================");
		System.out.println("1.등록 | 2.수정 | 3.삭제 | 4.부서조회 | 5.전체조회 | 9.종료 ");
		System.out.println("==================================================");
	}
	
	private int selectMenu() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");
		}
		return menu;
	}
	
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	private void inputError() {
		System.out.println("메뉴에 맞게 입력해주세요.");
	}
	
	private void insertDepartment() {
		//사원정보 입력
		Department dpmt = inputAll();
		//DB에 전달
		dao.insert(dpmt);
	}
	
	private void updateDepartment() {
		//수정하는 정보 입력
		Department dpmt = inputUpdateInfo();
		//DB에 전달
		dao.update(dpmt);
	}
	
	private void deleteDepartment() {
		//사원번호 입력
		int departmentId = inputDepartmentId();
		//DB에 전달
		dao.delete(departmentId);
	}
	
	private void selectDepartment() {
		//사원번호 입력
		int departmentId = inputDepartmentId();
		//DB검색
		Department dpmt = dao.selectOne(departmentId);
		//결과 출력
		if(dpmt != null) {
			System.out.println(dpmt);
		}else {
			System.out.println("원하는 정보가 존재하지 않습니다.");
		}
	}
		
	private void selectAllDepartment() {
		List<Department> list = dao.selectAll();
		for(Department dpmt : list) {
			System.out.println(dpmt);
		}
	}
	
	private Department inputAll() {
		Department dpmt = new Department();
		System.out.println("부서번호:");
		dpmt.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.println("부서이름:");
		dpmt.setDepartmentName(sc.nextLine());
		System.out.println("매니저번호:");
		dpmt.setDepartmentId(Integer.parseInt(sc.nextLine()));
		System.out.println("지역:");
		dpmt.setDepartmentId(Integer.parseInt(sc.nextLine()));
		
		return dpmt;
		
	}
	
	private Department inputUpdateInfo() {
		Department dpmt = new Department();
		System.out.println("부서이름:");
		dpmt.setDepartmentName(sc.nextLine());
		System.out.println("부서번호:");
		dpmt.setDepartmentId(Integer.parseInt(sc.nextLine()));

		return dpmt;
	}
	
	private int inputDepartmentId() {
		System.out.println("부서번호:");
		return Integer.parseInt(sc.nextLine());
	}

}