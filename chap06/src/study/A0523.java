package study;


public class A0523 {
		
	int[] num;
	int index;
		
	A0523(){
		index = -1;
	}
	//- "1.학생수 입력 
	void studentN(int N) {
		num = new int[N];
	}
	//2.학생점수 등록 
	void studentS(int S) {
		num[++index] = S;
	}
	//3.학생점수 전체조회 
	void studentAll() {
		for(int i = 0; i<num.length; i++) {
			System.out.println("score[" + i + "]:" + num[i]);
		}
	}
	int max() {
		int max = num[0];
		for (int i = 0; i<num.length; i++) {
			if (max < num[i]);{
				max = num[i];
			}
		}
		return max;
	}
	int min() {
		int min = num[0];
		for (int i = 0; i<num.length; i++) {
			if (min < num[i]);{
				min = num[i];
			}
		}
		return min;
	}
	
	//평균
	//double Avg() {
	//	double num=0;
	//	double Avg = 0;
	//	for (double i = 0; i<num.length; i++) {
	//		num += num[i];
	//	}
	//	return Avg;
	//}


}
	//4.학생정보 분석 
	//종료" 메뉴를 구성
	//		- 입력받은 학생 수에 등록할 수 있는 학생점수 수가 정해지도록 구현하세요.
	//		- 아래를 참조해서 각 학생의 점수를 입력하세요.
	




	//			1) 점수 : 100점
	//			2) 점수 : 73점
	//			3) 점수 : 92점
	//			4) 점수 : 65점
	//			5) 점수 : 86점


