package operator;

import java.io.IOException;
import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
				
		int rand = 5;//(int) (Math.random()*10+1);	//나중에 난수로 바꿀것임
		int num;		//유저가 입력하는 값
		int count = 1;
		String result;
		
		//do {						//반복
		//	num = scan.nextInt();	//키보드 정수값을 읽어서 num 변수에 저장
			
		//	if(rand>num) {
		//		result = "크다";
		//	}						//rand > num "크다" 출력
		//	else if(rand<num) {
		//		result = "작다";
		//	}						//rand < num "작다" 출력
		//	else{
		//		break;
		//	}						//rand == num break
		//
		//	System.out.println(result);
	//	}while(true);

		
		do {						
			count++;
			num = scan.nextInt();
			
			if(rand > num) {
				System.out.println("크다");
			}
			else if(rand < num) {
				System.out.println("작다");
			}
			else{
				System.out.println("맞다");
				break;
			}
			//count가 5회이상이면 게임종료
			if(count>5) {
				break;
			}
				
		}while(true);
		
	}
}
