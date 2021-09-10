package chap06;

import java.util.Scanner;

public class BubbleSort {

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void bubbleSort(int[] a) {
		int n = a.length;
		for(int i = 0; i<n-1; i++)
			for(int j = n-1; j>i; j--)
				if(a[j-1] > a[j])
					swap(a, j-1, j);
	}
	
	static void bubbleSort2(int[] a) {
		int n = a.length;
		for(int i = n-1; i>1; i--) 
			for(int j = 0; j<i; j++)
				if(a[j]>a[j+1])
					swap(a, j, j+1);
	}
	
	static void bubbleSort3(int[] a) {
		int n = a.length;
		int count = 0;
		int sw = 0;
		for(int i = 0; i<n-1; i++) {
			System.out.println("패스 "+i+" :");
			int exch = 0;
			for(int j = n-1; j>i; j--) {
				count++;
				if(a[j-1] > a[j]) {
					for(int k = 0; k < a.length; k++) {
						if(k == j) {
							System.out.print(" +");
							System.out.printf("%2d",a[k]);
						}else System.out.printf("%4d",a[k]);
					}
					System.out.println();
					swap(a, j-1, j);
					sw++;
					exch++;
				}else {
					for(int k = 0; k < a.length; k++) {
						if(k == j) {
							System.out.print(" -");
							System.out.printf("%2d",a[k]);
						}else System.out.printf("%4d",a[k]);
					}
					System.out.println();
				}
			}
			if(exch == 0) break;
				
		}
		System.out.println("비교를 "+count+"회 했습니다.");
		System.out.println("교환을 "+sw+"회 했습니다.");
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("버블 정렬(버전 1)");
		System.out.print("요솟수 : ");
		int nx = in.nextInt();
		int[] x = new int[nx];
		
		for(int i = 0; i < nx; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = in.nextInt();
		}
		
		bubbleSort3(x);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i<nx; i++) {
			System.out.println("x["+i+"] = "+x[i]);
		}
	}

}
