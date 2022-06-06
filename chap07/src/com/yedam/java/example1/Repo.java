package com.yedam.java.example1;

import java.util.Iterator;

//고객정보를 저장하는 저장소
public class Repo {
	// 필드
	private Customer[] dataList;
	private int listIndex;

	/// 생성자
	public Repo() {
		dataList = new Customer[100];
		listIndex = -1;
	}

	// 메소드
	// 등록
	public void insert(Customer customer) {
		dataList[++listIndex] = customer;
	}

	// 수정
	public void update(Customer customer) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getCustomerId() == customer.getCustomerId())
				;
			dataList[i] = customer;
		}
	}

	// 삭제
	public void delete(int customerId) {
		// 데이터 삭제
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getCustomerId() == customerId) {
				dataList[i] = null; // 원래는 오류뜨는데 일단 진행 -null 빈자리 cleanDataList돌려서 확인, 빈칸 지우고 다시 넣는거
			}
		}
	// 데이터 정리
		cleanDataList();
	}
	private void cleanDataList() {
		// 기존 데이터, 임시 변수에 복사
		Customer[] temp = dataList;
		int tempIndex = listIndex;
		// 기존 데이터 초기화
		this.dataList = new Customer[100];
		this.listIndex = -1;
		for (int i = 0; i < tempIndex; i++) {
			if (temp[i] == null) {
				continue;
			}
			dataList[++listIndex] = temp[i];
		}
	}

	// 조회
	public Customer[] selectAll() {
		return dataList;
	}
	
	public Customer selectOne(int customerId) {
		Customer selected = null;
		for (int i = 0; i <= listIndex; i++) {
			if(dataList[i].getCustomerId() == customerId) {
				selected = dataList[i];
				break;
			}
		}
			return selected;
	}

}
