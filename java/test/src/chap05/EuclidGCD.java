package chap05;

import java.util.Scanner;

class EuclidGCD {

	static int gcd(int x, int y) {
		if(y==0)
			return x;
		else
			return gcd(y, x%y);
	}
	
	static int gcdFor(int x, int y) {
		int i = 0;
		do {
			i = x;
			x = y%x;
			y = i;
		}while(x>0);
		return y;
	}
	
	static int gcdArray(int[] a, int n) {
		if(n == 1)
			return a[n-1];
		if(n >= 2)
			return gcd(a[n-2], a[n-1]);
		else
			return gcd(a[n], gcdArray(a, n-1));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] a = {6,8,10,12};
		
		System.out.println(gcdArray(a, 4));
//		System.out.println("두 정수의 최대공약수를 구합니다.");
//		
//		System.out.print("정수를 입력하세요 : "); int x = in.nextInt();
//		System.out.print("정수를 입력하세요 : "); int y = in.nextInt();
//		
//		System.out.println("최대공약수는 " + gcdFor(x, y) + "입니다.");
		
		
	}

}
