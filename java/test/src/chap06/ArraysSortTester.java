package chap06;

import java.util.Scanner;
import java.util.Arrays;

public class ArraysSortTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = in.nextInt();
		int[] x = new int[num];
		
		for(int i = 0; i<num; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = in.nextInt();
		}
		
		Arrays.sort(x);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i<num; i++)
			System.out.println("x["+i+"] = "+x[i]);
	}

}
