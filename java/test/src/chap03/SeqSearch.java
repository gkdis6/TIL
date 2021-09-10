package chap03;

import java.util.Scanner;

public class SeqSearch {

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
		int[] m = new int[num];
		int inde = SearchIdx(x, key, m);
		for(int i = 0; i<inde; i++)
			System.out.println("x["+m[i]+"]에 있습니다.");
		System.out.println("총 "+inde+"개 입니다.");
	}
	
	static int seqSearch(int[] a, int key) {
		int i = 0;
		a[a.length-1] = key;
		for(i = 0; i < a.length; i++) {
			if(a[i] == key) {
				break;
			}
		}
		return i==a.length-1 ? -1 : i;
	}
	static int SearchIdx(int[] a, int key, int[] idx) {
		int i, count = 0;
		a[a.length-1] = key;
		for(i = 0; i < a.length-1; i++) {
			if(a[i] == key) {
				idx[count++] = i;
			}
		}
		return count;
	}

}
