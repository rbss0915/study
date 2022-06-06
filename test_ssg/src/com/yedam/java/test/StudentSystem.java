package com.yedam.java.test;

public class StudentSystem {
	public Student[] list;
	public int index;
	
	public StudentSystem() {
		index =-1;
	}
	//1.학생수 입력
	public void studentSize(int size) {
		list = new Student[size];
	}
	//2.학생정보 등록
	public void putStudentInfo(int num, String name, int score) {
		Student student = new Student();
		student.setNum(num);
		student.setName(name);
		student.setScore(score);
		
		list[++index] = student;
	}
	//3.학생정보 전체조회
	public void printList() {
		for(int i=0; i<= index; i++) {
			Student student = list[i];
			System.out.println(list[i].getNum() + " 학번의 점수는 " + list[i].getScore() + "입니다" );
		}
	}
	//4.학생저보 분석
	//4-1 max
	public Student getMaxScore() {
		Student maxInfo = list[0];
		for(int i=1; i<=index; i++) {
			if(maxInfo.getScore() < list[i].getScore()) {
			maxInfo = list[i];
			}
		}
		return maxInfo;
	}
	//4-2 min
	public Student getMinScore() {
		Student minInfo = list[0];
		for(int i=1; i<=index; i++) {
			if(minInfo.getScore() > list[i].getScore()) {
			minInfo = list[i];}
		}
		return minInfo;
	}
	//4-3 avg
	public double getAvg() {
		double sum = 0;
		double result = 0;
		for(int i = 0; i < list.length; i++) {
			sum += list[i].getScore();
		}
		result = (sum - (getMaxScore().getScore() + getMinScore().getScore())) / 3;
		return result;
	}
	
	
	//5.종료

}
