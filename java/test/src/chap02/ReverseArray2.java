package chap02;

import java.util.Scanner;

public class ReverseArray2{

	public static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
		System.out.println("a["+idx1+"]과(와) a["+idx2+"]를 교환합니다.");
	}
	
	public static void reverse(int[] a) {
		for(int i =0; i < a.length/2; i++) {
			for(int j = 0; j<a.length; j++) {
				System.out.print(a[j]+" ");
			}
			System.out.println();
				
			swap(a, i, a.length-i-1);
		}
		System.out.println("역순 정렬을 마쳤습니다.");
			
	}
	
	public static int sumOf(int[] a) {
		int sum = 0;
		for(int i = 0; i<a.length; i++)
			sum += a[i];
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = in.nextInt();
		
		int[] x = new int[num];
		
		for(int i = 0; i<num; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = in.nextInt();
		}
		
		reverse(x);
		
	}
}
