package chap01;

import java.util.Scanner;

public class SumForQ7 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.print("n의 값 : ");
		int n = in.nextInt();
		
		int sum = 0;
		String m = "";
		
		for(int i = 1 ; i <= n; i++){
			sum += i;
			if(i != 1) {
				m += " + "+i;
			}
			else m += "1";
		}
		
		System.out.println(m+" = "+sum);
	}

}
