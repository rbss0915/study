package array;

import java.util.Scanner;

public class MainApp {

	// 배열선언
	static int scores[];
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// 배열생성과 초기화
		init();

		// 반복문
		// 메뉴출력 입력1.전체출력 2.최솟값 3.최댓값 4.평균 5.종료
		// 메뉴입력
		// 1.
		// printALL();
		// 2.
		// findMin();
		// 3.
		// findMax();
		// 4.
		// findAvg();
		// 5. 종료
		boolean run = true;
		int menu;
		do{
			System.out.println(" ----------------------------------------- ");
			System.out.println(" 1.전체출력 | 2.최솟값 | 3.최댓값 | 4.평균 | 5.종료 ");
			System.out.println(" ----------------------------------------- ");
			System.out.println("선택> ");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				printALL();
				break;
			case 2:
				findMin();
				break;
			case 3:
				findMax();
				break;
			case 4:
				findAvg();
				break;
			case 5:
				System.out.println("종료");
				break;
			default:
				System.out.println("1~5입력");
			}
			
			
		}while(menu != 5);
	}

	public static void init() {
		scores = new int[10]; // 모든 요소가 0으로 초기화
		// 배열초기화
		for (int i = 0; i < 10; i++) {
			scores[i] = scan.nextInt();
		}
	}

	public static void printALL() {
		// 배열값전체조회
		for (int i = 0; i < 10; i++) {
			System.out.println(scores[i]);
		}
		// 두번째 학생의 성적 출력
		System.out.println("두번째 학생은 " + scores[1] + "점 입니다.");
	}

	public static void findMin() {
		// 최솟값
		int min = scores[0];
		for (int i = 1; i < 10; i++) {
			if (min > scores[i]) { // 배열의 i번째 인덱스의 값과 min을 비교
				min = scores[i];
			}
		}
		System.out.println("min :" + min);
	}

	public static void findMax() {
		int max = scores[0];
		for (int i = 1; i < 10; i++) {
			if (max < scores[i]) {
				max = scores[i];
			}
		}
		System.out.println("max :" + max);
	}

	public static void findAvg() {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += scores[i];
		}
		System.out.println("sum: " + sum);
		System.out.println("avg: " + sum / 10);
	}

}
