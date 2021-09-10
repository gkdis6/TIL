package chap03;

import java.util.Scanner;

public class SeqSearch2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = in.nextInt();
		int[] x = new int[num+1];
		for(int i = 0; i<num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = in.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int key = in.nextInt();
		int idx = seqSearch(x, key);
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(key+"은(는) x["+idx+"]에 있습니다.");
	}
	
	static int seqSearch(int[] a, int key) {
		int i = 0;
		a[a.length-1] = key;
		System.out.print("   |");
		for(int j = 0; j<a.length-1; j++) {
			System.out.printf("%4d", j);
		}
		System.out.print("\n---+");
		for(int j = 0; j<a.length-1; j++) {
			System.out.print("----");
		}
		System.out.println();
		for(i = 0; i < a.length; i++) {
			if(i != a.length-1) {
				System.out.print("   |");
				for(int j = 0; j<=i; j++) {
					if(j==a.length-1)
						continue;
					if(j==i)
						System.out.print("   *");
					else
						System.out.print("    ");
				}
				System.out.println();
				for(int j = 0; j<a.length-1; j++) {
					if(j == 0)
						System.out.printf("%3d|%4d",i,a[j]);
					else
						System.out.printf("%4d",a[j]);
					if(j == a.length-2)
						System.out.println();
				}
			}
			if(a[i] == key) {
				break;
			}
			if(i < a.length-2)
				System.out.println("   |");
			
			
		}
		return i==a.length-1 ? -1 : i;
	}

}
