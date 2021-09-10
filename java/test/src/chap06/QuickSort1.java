package chap06;

import java.util.Scanner;

public class QuickSort1 {

	static int med3(int a, int b, int c) {
		if (a >= b)
			if (b >= c)
				return b;
			else if (a <= c)
				return a;
			else
				return c;
		else if (a > c)
			return a;
		else if (b > c)
			return c;
		else
			return b;
	}
	
	static int swapMed(int[] x, int a, int b, int c) {
		if (x[b] < x[a])
			swap(x, b, a);
		if (x[c] < x[b])
			swap(x, c, b);
		if (x[b] < x[a])
			swap(x, b, a);
		return b;
	}
	
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
	}
	
	static void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x;
		int m = swapMed(a, pl, (pr+pl)/2, pr);
		x = a[m];
		swap(a, m, right - 1);
		pl++;
		pr--;
		
		System.out.printf("a[%d]~a[%d] : {", left, right);
		for(int i = left; i<right; i++)
			System.out.printf("%d, ",a[i]);
		System.out.printf("%d}\n",a[right]);
		
		do {
			while(a[pl]<x) pl++;
			while(a[pr]>x) pr--;
			if(pl <= pr)
				swap(a, pl++, pr--);
		}while(pl <= pr);
		
		if(left < pr) quickSort(a, left, pr);
		if(pl < right) quickSort(a, pl, right);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("퀵 정렬");
		System.out.print("요솟수 : ");
		int nx = in.nextInt();
		int[] x = new int[nx];
		
		for(int i = 0; i<nx; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = in.nextInt();
		}
		
		quickSort(x, 0, nx-1);
		
		System.out.println("오름차순으로 정렬했습니다.");
		System.out.print("{");
		for(int i = 0; i<nx-1; i++)
			System.out.printf("%d, ", x[i]);
		System.out.printf("%d}\n", x[nx-1]);
	}

}
