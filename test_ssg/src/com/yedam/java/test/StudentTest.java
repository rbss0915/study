package com.yedam.java.test;

import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
			boolean run = true;
		    Scanner sc = new Scanner(System.in);
		    StudentSystem Student = new StudentSystem();
		    
		    while(run) {
		         System.out.println("메뉴를 선택하세요");
		         System.out.println("1.학생수 입력 | 2.학생정보 등록 | 3.학생정보 전체조회 | 4.학생정보 분석 | 5.종료" );
		         System.out.println("입력 : ");
		         int selectNo = sc.nextInt();
		         
		         if(selectNo == 1) {
		             System.out.println("1.학생 수 : ");
		             int size = sc.nextInt();
		             Student.studentSize(size);
		             System.out.println();
		          }
		          else if(selectNo ==2) {
		             System.out.println("2.학생정보 등록");
		             System.out.println("학번 : ");
		             int num = sc.nextInt();
		             System.out.println("이름 : ");
		             String name = sc.next();
		             System.out.println("점수 : ");
		             int score = sc.nextInt();
		             Student.putStudentInfo(num, name,score);
		          }
		          else if(selectNo ==3) {
		             System.out.println("3.학생정보 전체조회:");
		             Student.printList();
		          }
		          else if(selectNo ==4) {
		             System.out.println("4.분석");
		             System.out.println("최고 점수 :" +Student.getMaxScore().getScore()+ "점, 학번 :" + Student.getMaxScore().getNum());
		             System.out.println("최저 점수 :" +Student.getMinScore().getScore()+ "점, 학번 :" + Student.getMinScore().getNum());
		             System.out.printf("최고점, 최저점을 제외한 평균 점수는 %.2f점입니다.", Student.getAvg());
		          }
		          else if(selectNo == 5) {
		             run = false;
		             System.out.println("5.프로그램 종료");
		          }
		          else
		             System.out.println("메뉴를 다시 선택하세요.");
		          }
		       } 
		 }