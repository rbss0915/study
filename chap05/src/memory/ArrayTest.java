package memory;

public class ArrayTest {

	public static void main(String[] args) {

		int[] month = new int[] {30,28,31,30,31,31}; //new int[] 값없이 원소 갯수로 판단함, 생략가능
		//2월달의 마지막날은?
		System.out.println(month[1]);
		int[] week = {'월', '화', '수'};
		
		int[] score = new int[10];
		//score = {4,6,10,3,5}; error, int 선언 할.때. 가능. 배열 만든후로는 하나씩 담아야됨
		score[0] = 100;
	}

}
