package operator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WhileTest1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		//while1();
		//for1();
		//for2();
		//gugudan1();
		//findMax();	//최댓값
		//findmin();	//최솟값
		findMinMax();
		
		}
	
	public static void findMinMax() throws FileNotFoundException {
		Scanner scan =new Scanner(new File("score.txt"));
		int min = scan.nextInt();
		int max = min;
		for (int i = 0; i < 9; i++) {
			int num = scan.nextInt();
			
			if(num < min) {
				min = num;
			}
			if(num > max) {
				max = num;
			}
			
		}
		System.out.println("최솟값=" + min);
		System.out.println("최댓값=" + max);
	}
	
	public static void findmin() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("score.txt"));
		int min = 100;
		for(int i = 0; i < 10; i++) {
			int num = scan.nextInt();
			if(num < min) {
				min = num;
			}
		}
		System.out.println("최솟값=" + min);

	}
	
	public static void findMax() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("score.txt"));
		int max = 0;
		for (int i = 0; i < 10; i++) {
			int num = scan.nextInt();
			if(num > max ) {
				max = num;
			}
		}
		System.out.println("최댓값=" + max);
			//10번 반복
			//숫자를 입력
			//60보다 크면 출력
		
	}
	
	//5단출력
	public static void gugudan1() {
		Scanner scan= new Scanner(System.in);
		int dan = scan.nextInt();
		for(int i = 1; i <=9; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan*i);		//5*2=10
		}
	}
	
	//10~1 출력
	public static void for2() {
		for(int i = 10; i >= 1 ; i--) {
			System.out.println(i +"반복");
		}
	}
	
	
	public static void for1() {
		for(int i = 1; i <= 10 ; i=i+2) {
			System.out.println(i +"반복");
		}
	}
	
			
	public static void while1() {
		int count = 1;
				
		do {
			System.out.println(count);
			count++;
			}while(count<=1);
	}
	
}

