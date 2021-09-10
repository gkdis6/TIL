package chap05;

import java.util.Scanner;

import chap04.IntStack;

public class Recur {
	
	static void recur(int n) {
		if(n > 0) {
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);
		}
	}
	
	static void recur2(int n) {
		if(n > 0) {
			recur(n - 2);
			System.out.println(n);
			recur(n - 1);
		}
	}
	
	static void recurX1(int n) {
		while(n>0) {
			recur(n-1);
			System.out.println(n);
			n = n-2;
		}
	}
	
	static void recurX2(int n) {
		IntStack s = new IntStack(n);
		
		while(true) {
			if(n>0) {
				s.push(n);
				n = n - 1;
				continue;
			}
			if(s.isEmpty() != true) {
				n = s.pop();
				System.out.println(n);
				n = n-2;
				continue;
			}
			break;
		}
	}
	
	static void recur3(int n) {
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int x = in.nextInt();
		
		//recur(x);
		recurX2(x);
	}

}
