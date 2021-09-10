package chap05;

import java.util.Scanner;

class Factorial {
	
	static int factorial(int n) {
		if(n>0)
			return n * factorial(n-1);
		else
			return 1;
	}
	
	static int factorialFor(int n) {
		int x = 1;
		if(n < 2) {}
		else {
			for(int i = 2; i<=n; i++)
				x = x * i;
		}
		return x;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int x = in.nextInt();
		
		System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
	}

}
