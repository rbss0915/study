package com.yedam.java.ch0604;

public class Calculator {
	int[] numList;
	int index;
	
	Calculator(){
		index = -1;
	}
	
	//1.갯수 입력
	void setArraySize(int size) {
		numList = new int[size];
	}
	//2.숫자 입력
	void setNum(int num) {
		if((index+1) < numList.length) {
			numList[++index] = num;	//두개 단위 일치+1..뭔말이고ㅡㅡ
		}else {
			System.out.println("더이상 숫자입력안됨");
		}
	}
	//3.더하기
	void plus() {
		if(isExecuted()) {
			int sum = 0; //누적해야되니까 바닥
			for(int i =0; i<= index; i++) {
				sum+=numList[i];
			}
			System.out.println("더한결과:"+sum);
		}
	}
	//4.빼기
	void minus() {
		if(isExecuted()) {
			int result = numList[0];  //배열첫값 [0]
			for(int i =1; i<= index; i++) { //첫값제외니까 1
				result-=numList[i];
			}
			System.out.println("뺀결과:"+result);
		}
	}
	//5.곱하기
	void multi() {
		if(isExecuted()) {
			int result = numList[0];
			for(int i =1; i<= index; i++) {
				result*=numList[i];
			}
			System.out.println("곱한결과:"+result);
		}
	}
	//6.나누기
	void divid() {
		if(isExecuted()) {
			int result = numList[0];
			for(int i =1; i<= index; i++) {
				result/=numList[i];
			}
			System.out.println("나눈결과:"+result);
		}
	}
	
	//0.조건 체크
	boolean isExecuted() {
		if((index+1) >=2) {
			return true;
		}else {
			System.out.println("숫자를 더입력해주세요");
			return false;
		}
	}
}
