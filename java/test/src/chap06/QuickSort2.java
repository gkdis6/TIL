package chap06;

import java.util.Scanner;

import chap04.IntStack;

public class QuickSort2 {
	
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
	}

	static void quickSort(int[] a, int left, int right) {
		if(right<10) {
			for(int i = left; i < right; i++) {
				int j;
				int tmp = a[i];
				for(j = i; j> 0 && a[j-1] > tmp; j--)
					a[j] = a[j-1];
				a[j] = tmp;
			}
			return;
		}
		
		IntStack lstack = new IntStack(right - left +1);
		IntStack rstack = new IntStack(right - left +1);
		
		lstack.push(left);
		rstack.push(right);
		
		while(lstack.isEmpty() != true) {
			int pl = left = lstack.pop();
			int pr = right = rstack.pop();
			int x = a[(left+ right) /2];
			
			do {
				while(a[pl] < x) pl++;
				while(a[pr] > x) pr--;
				if(pl <= pr)
					swap(a, pl++, pr--);
			}while(pl <= pr);
			
			if(pr-left > right-pl) {
				if(left < pr) {
					lstack.push(left);
					rstack.push(pr);
				}
				if(pl < right) {
					lstack.push(pl);
					rstack.push(right);
				}
			}else{
				if(pl < right) {
					lstack.push(pl);
					rstack.push(right);
				}
				if(left < pr) {
					lstack.push(left);
					rstack.push(pr);
				}
			}
			
			
		}
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
