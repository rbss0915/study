package chap01;
/*
 * 과제1
 */
public class work01 {
	public static void main(String[] args) {
		변수선언();
	}

	
	//아래의 변수 앞에 알맞은 타입을 적고 아래의 결과처럼 변수 출력
	public static void 변수선언() {
		
		char grade			=	'상';
		String schoolName	=	"예담";
		int score			=	85;
		double average		=	4.235;
		int flag			=	0b10000000;
		char firstChar		=	'\uAC00';
		char secondChar		=	0xAC01;
		int salary			=	1_000_000;
		boolean useYn		=	true;
		
	System.out.println("grade=" + grade);
	System.out.print("schoolName=" + schoolName + "\n");
	System.out.print("score=" + score + "\n");
	System.out.print("average=" + average + "\n");
	System.out.println("flag=" + flag);
	System.out.println("firstChar=" + firstChar);
	System.out.println("secondChar=" + secondChar);
	System.out.println("salary=" + salary);
	System.out.println("useYn=" + useYn);
	
	}
}
