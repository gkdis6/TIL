package chap01;

import java.util.Scanner;

public class SumForQ8 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.print("n의 값 : ");
		int n = in.nextInt();
		
		int sum = (1+n)*n/2;
		
		System.out.println("1부터 "+n+"까지의 합은 "+sum+"입니다.");
		
		SumForQ9 s9 = new SumForQ9();
	}

}
