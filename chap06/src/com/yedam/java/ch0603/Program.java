package com.yedam.java.ch0603;

//201p 6번
//1.학생수입력
//2.점수입력
//3.점수리스트 출력
//분석 - 최고점수, 평균점수

public class Program {

	//필드
	int[] scores;
	int index;
	//생성자
	Program(){
		index = -1;
	}
	//매소드
	
	//학생수 입력 - 배열초기화 위해
	void setStudentNum(int student) {
		scores = new int[student];
	}
	void setStudentScore(int score) {
		scores[++index] = score; //-1 이 0이된 다음 스코어로 넘어감
	}
	//점수리스트 출력
	void printScores() {
		for(int i =0; i<scores.length; i++) {
			System.out.println("scores[" + i +"]:" + scores[i]);
		}
	}
	//4-1. 최고점수
	int getMaxScore() {
		int max = scores[0];
		for(int i=0; i<scores.length; i++) {
			int temp = scores[i];
			if(max<temp) {
				max = temp;
			}
		}
		return max;
	}
	//4-2.평균점수
	double getAvgScore() {
		int sum = 0;
		for(int i =0; i<scores[i]; i++) {
			sum += scores[i];
			//sum = sum + scores[i];
		}
		//return sum / scores.length;  //둘다int임 소수점음슴
		return (double)sum / scores.length;  //둘다int임 소수점음슴
	}
	
	//4-3.분석
	void printResult() {
		System.out.println("최고 점수 : " + getMaxScore());
		System.out.println("평균 점수 : " + getAvgScore());
	}
	
}
