package com.yedam.java.testAgain;

public class Student {
	//필드
	public int num;
	public String name;
	public int score;
	
	//생성자
	public Student() {}
	
	public Student(int num, String name, int score) {
		this.num = num;
		this.name = name;
		this.score = score;
	}
	//메소드
	public void setNum(int num) {
		this.num = num;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getNum() {
		return this.num;
	}
	public String getName() {
		return this.name;
	}
	public int getScore() {
		return this.score;
	}
	public void showInfo() {
		System.out.println("학번 :" + num + "이름 :" + name + "점수 : " + score);
		
	}
	
	

}
