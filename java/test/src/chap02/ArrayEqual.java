package chap02;

import java.util.Scanner;

public class ArrayEqual {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("배열 a의 요솟수 : ");
		int na = in.nextInt();
		
		int[] a = new int[na];
		
		for(int i = 0; i<na; i++) {
			System.out.print("a["+i+"] : ");
			a[i] = in.nextInt();
		}
		System.out.print("배열 b의 요솟수 : ");
		int nb = in.nextInt();
		
		int[] b = new int[nb];
		
		for(int i = 0; i<nb; i++) {
			System.out.print("a["+i+"] : ");
			b[i] = in.nextInt();
		}
		System.out.println("배열 a와 b는 " +
				(equals(a,b) ? "같습니다." : "같지 않습니다."));
	}

	public static boolean equals(int[] a, int[] b) {
		if(a.length != b.length)
			return false;
		
		for(int i = 0; i<a.length;i++) {
			if(a[i] != b[i])
				return false;
		}
		return true;
	}
	
	public static void copy(int[] a, int[] b) {
		for(int i =0; i<a.length; i++)
			a[i] = b[i];
	}
	
	public static void rcopy(int[] a, int[] b) {
		for(int i =0; i<a.length; i++)
			a[i] = b[a.length-i-1];
	}
}
