package chap02;

import java.util.Scanner;

public class CardConvRev {

	public static int cardConvEx(int x, int r, char[] d) {
		int digits = 0;
		int n = ((Integer) x).toString().length();
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		System.out.printf(String.format("%%2d | %%%dd\n", n), r, x);
		
		do {
			System.out.print("  +");
			for(int i = 0; i<n+2; i++)
				System.out.print("-");
			System.out.println();
			
			if(x/r != 0) 
				System.out.printf(String.format("%%2d | %%%dd  … %%d\n", n), r, x / r, x % r);
			else
				System.out.printf(String.format("     %%%dd  … %%d\n", n), x / r, x % r);
				d[digits++] = dchar.charAt(x % r);
				x /= r;
		} while (x != 0);
			for (int i = 0; i < digits / 2; i++) {
				char temp = d[i];
				d[i] = d[digits - i - 1];
				d[digits - i - 1] = temp;
			}
		return digits;
	}
	
	public static int cardConvR(int x, int r, char[] d) {
		int digits = 0;
		String dcharString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			d[digits++] = dcharString.charAt(x/r);
			x/=r;
		}while(x != 0);
		return digits;
		
	}
	
	public static int cardConv(int x, int r, char[] d) {
		int num = cardConvR(x, r, d);
		char ca;
		for(int i = 0; i<(num-1)/2;i++) {
			ca = d[i]; d[i] = d[num-i-1]; d[num-i-1] = ca;
		}
		return num;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int no, cd, dno, retry;
		char[] cno = new char[32];
		
		System.out.println("10진수를 기수 변환합니다.");
		do {
			do {
				System.out.print("변환하는 음이 아닌 정수 : ");
				no = in.nextInt();
			}while(no<0);
			
			do {
				System.out.print("어떤 진수로 변환할까요? (2~36) : ");
				cd = in.nextInt();
			}while(cd<2||cd>36);
			dno = cardConvR(no, cd, cno);
			
			System.out.print(cd + "진수로는 ");
			for(int i = dno-1; i>=0; i--)
				System.out.print(cno[i]);
			System.out.println("입니다.");
			
//			dno = cardConv(no, cd, cno);
//			System.out.print(cd + "진수로는 ");
//			for(int i = 0; i<dno; i++)
//				System.out.print(cno[i]);
//			System.out.println("입니다.");
			
			System.out.print("한 번 더 할까요? (1. 예/0. 아니요) : ");
			retry = in.nextInt();
		}while(retry == 1);
	}
}
