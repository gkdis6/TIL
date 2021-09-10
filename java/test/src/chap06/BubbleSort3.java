package chap06;

import java.util.Scanner;

public class BubbleSort3 {

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void bubbleSort(int[] a) {
		int n = a.length;
		int count = 0;
		int sw = 0;
		int l = 0;
		for(int i = 0; l<n-1; i++) {
			System.out.println("패스 "+i+" :");
			int exch = 0;
			int last = n - 1;
			for(int j = n-1; j>l; j--) {
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
					last = j;
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
			l = last;
			if(exch == 0) break;
		}
		System.out.println("비교를 "+count+"회 했습니다.");
		System.out.println("교환을 "+sw+"회 했습니다.");
	}
	
	static void shakingSort(int[] a) {
		int n = a.length;
		int left = 0;
		int right = n-1;
		int last = right;
		
		while(left<right) {
			for(int i = left; i<right; i++) {
				if(a[i]>a[i+1]) {
					swap(a, i, i+1);
					last = i;
				}
			}
			right = last;
			
			for(int j = right; j>left; j--) {
				if(a[j]<a[j-1]) {
					swap(a, j, j-1);
					last = j;
				}
			}
			left = last;
		}
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
		
		shakingSort(x);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i<nx; i++) {
			System.out.println("x["+i+"] = "+x[i]);
		}
	}

}
