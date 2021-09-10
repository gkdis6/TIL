package chap06;

import java.util.Scanner;


public class SelectionSort {
	
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void selectionSort(int[] a) { //단순 선택 정렬
		int n = a.length;
		for(int i = 0; i< n-1; i++) {
			int min = i;
			for(int j = i+1; j<n; j++) {
				if(a[j] < a[min]) {
					min = j;
				}
			}
			for(int k = 0; k <= min; k++) {
				if(k == min)
					System.out.println("  +");
				else if(k == i)
					System.out.print("  *");
				else
					System.out.print("   ");
			}
			for(int k = 0; k<a.length; k++)
				System.out.printf("%3d",a[k]);
			System.out.println();
			swap(a, i, min);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("단순 선택 정렬");
		System.out.print("요솟수 : ");
		int nx = in.nextInt();
		int[] x = new int[nx];
		
		for(int i = 0; i< nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = in.nextInt();
		}
		
		selectionSort(x);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i< nx; i++)
			System.out.println("x[" + i + "] = " + x[i]);
	}

}
