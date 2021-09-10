package chap02;

import java.util.Scanner;

public class MaxOfArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int num = in.nextInt();
		
		int[] height = new int[num];
		
		for(int i = 0; i<num; i++) {
			System.out.print("height["+i+"] : ");
			height[i] = in.nextInt();
		}
		System.out.println("최댓값은 "+maxOf(height)+"입니다.");
	}
	
	public static int maxOf(int[] a) {
		int max = a[0];
		
		for(int i = 1; i<a.length; i++) {
			if(a[i]>max) {
				max = a[i];
			}
		}
		return max;
	}

}
