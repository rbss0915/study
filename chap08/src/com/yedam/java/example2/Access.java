package com.yedam.java.example2;

public interface Access {
	//저장소에 대해 사용방법을 정의
	//등록
	public void insert(Student student);
	//수정
	public void update(Student student);
	//삭제
	public void delete(int student);
	//전체조회
	public Student[] selcetAll();
	//단건조회
	public Student selcetOne(int studentId);
}
