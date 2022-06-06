package backjun.p10871;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		int x;
		int i=1;
		int num;
		
		n = scan.nextInt();
		x = scan.nextInt();
		do {
			num = scan.nextInt();
			if(num < x) {
				System.out.println(num+" ");
			}
			i++;
		}while(i<=n);
	}

}
