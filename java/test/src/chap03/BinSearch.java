package chap03;

import java.util.Scanner;

public class BinSearch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = in.nextInt();
		int[] x = new int[num];
		
		System.out.println("오름차순으로 입력하세요.");
		
		System.out.print("x[0] : ");;
		x[0] = in.nextInt();
		
		for(int i = 1; i<num; i++) {
			do {
				System.out.print("x["+i+"] : ");
				x[i] = in.nextInt();
			}while(x[i]<x[i-1]);
		}
		
		System.out.print("검색할 값 : ");
		int key = in.nextInt();
		
		int idx = binSearchX(x, key);
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(key + "은(는) x["+idx+"]에 있습니다." );
	}

	static int binSearch2(int[] a, int key) {
		int ps = 0;
		int pl = a.length-1;
		
		a[a.length-1] = key;
		System.out.print("   |");
		for(int j = 0; j<a.length; j++) {
			System.out.printf("%4d", j);
		}
		System.out.print("\n---+");
		for(int j = 0; j<a.length; j++) {
			System.out.print("----");
		}
		System.out.println();
		int count = 0;
		do {
			int pc = (ps + pl)/2;
			if(count != 0) {
				System.out.println("   |");
			}
			System.out.print("   |");
			for(int j = 0; j<=pl; j++) {
				if(j==ps)
					System.out.print("  <-");
				else if(j==pl) {
					System.out.print("  ->");
				}else if(j == pc)
					System.out.print("   +");
				else
					System.out.print("    ");
			}
			System.out.println();
			System.out.printf("%3d|", pc);
			for(int i = 0; i<a.length; i++) {
				System.out.printf("%4d",a[i]);
			}
			System.out.println();
			count++;
			if(a[pc] == key)
				return pc;
			else if(a[pc]<key)
				ps = pc +1;
			else
				pl = pc-1;
		}while(ps<=pl);
		return -1;
	}
	
	static int binSearch(int[] a, int key) {
		int ps = 0;
		int pl = a.length-1;
		
		do {
			int pc = (ps+pl)/2;
			if(a[pc] == key)
				return pc;
			else if(a[pc] < key)
				ps = pc+1;
			else
				pl = pc-1;
		}while(ps<=pl);
		
		return -1;
	}
	
	static int binSearchX(int[] a, int key) {
		int ps = 0;
		int pl = a.length-1;
		
		do {
			int pc = (ps+pl)/2;
			if(a[pc] == key) {
				for(; ps < pc; pc--)
					if(a[pc-1] < key)
						break;
				return pc;
			}else if(a[pc] < key)
				ps = pc+1;
			else
				pl = pc-1;
		}while(ps<=pl);
		
		return -1;
	}
}
