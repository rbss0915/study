package com.yedam.java.example2;

public class StudentRepo implements Access {
	//싱글톤//////////
	private static StudentRepo instance = new StudentRepo();
	private  StudentRepo(){
		init();
	}
	
	public static StudentRepo getInstance() {
		return instance;
	}
	//실제사용 필드 및 메소드///////
	private Student[] dataList;
	private int listIndex;
	
	private void init() {
		dataList = new Student[100];
		listIndex = -1;
	}
	
	
	@Override
	public void insert(Student student) {
		dataList[++listIndex] = student;
		
	}

	@Override
	public void update(Student student) {
		for (int i = 0; i <= listIndex; i++) {
			if(dataList[i].getId() == student.getId()) {
				dataList[i] = student;
			}
		}
	}
	@Override
	public void delete(int studentId) {
		for (int i = 0; i <=listIndex; i++) {
			if(dataList[i].getId() == studentId) {
				dataList[i] = null;
			}
		}
		cleanDataList();
	}
	///////////cleanDataList//////////////딜리트 빈값땜에
	private void cleanDataList() {
		//기존데이터 ->임시변수
		Student[] tempList = dataList;
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
	//////////cleanDataList////////////////
	@Override
	public Student[] selcetAll() {
		Student[] list = new Student[listIndex+1];
		for(int i=0; i<list.length; i++) {
			list[i] = dataList[i];
		}
		return list;
	}

	@Override
	public Student selcetOne(int studentId) {
		Student selected = null;
		for(int i = 0; i<= listIndex; i++) {
			if(dataList[i].getId() == studentId) {
				selected = dataList[i];
			}
		}
		return selected;
	}

	

}
