package chap06;

import java.util.Scanner;

public class InsertSort {

	static void insertionSort(int[] a) {
		int n = a.length;
		for(int i = 1; i < n; i++) {
			int j;
			int tmp = a[i];
			for(j = i; j> 0 && a[j-1] > tmp; j--)
				a[j] = a[j-1];
			a[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] x = null;
		
		System.out.println("단순 삽입 정렬");
		System.out.print("요솟수 : ");
		int nx = in.nextInt();
		if(nx > 0) {
			x = new int[nx];
			x[0] = -9999;
		}
		
		for(int i = 1; i< nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = in.nextInt();
		}
		
		insertionSort(x);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 1; i< nx; i++)
			System.out.println("x[" + i + "] = " + x[i]);
	}

}
