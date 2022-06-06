package homework0603;

import java.util.Scanner;


public class Human {
	//필드
	public static String name;
	public static int weight;
	public static int height;
	public static double standard;
	public static double bmi;
	
	//생성자
	public Human() {}
	//메소드
	Scanner sc = new Scanner(System.in);
	
	public void inputInfo() {
			
		System.out.println("이름 : ");
		name = sc.nextLine();
		
		System.out.println("몸무게 : ");
		weight = Integer.parseInt(sc.nextLine());
		
		System.out.println("키 : ");
		height = Integer.parseInt(sc.nextLine());
		
	}
	
	public void getInformation() {}
	

}
