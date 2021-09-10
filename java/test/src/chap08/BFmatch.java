package chap08;

import java.util.Scanner;

public class BFmatch {

	static int bfMatch(String txt, String pat) {
		int pt = 0;
		int pp = 0;
		int count = 0;
		int ppt = 0;
		
		while(pt != txt.length() && pp != pat.length()) {
			if(txt.charAt(pt) == pat.charAt(pp)) {
				if(count == pt) System.out.print(count+" ");
				else System.out.print("  ");
				
				System.out.println(txt);
				System.out.print("  ");
				for(int i = 0; i<pt; i++)
					System.out.print(" ");
				System.out.println("+");
				System.out.print("  ");
				for(int i = 0; i<pt-pp; i++)
					System.out.print(" ");
				System.out.println(pat+"\n");
				
				pt++;
				pp++;
			} else {
				if(count == pt) System.out.print(count+" ");
				else System.out.print("  ");
				
				System.out.println(txt);
				System.out.print("  ");
				for(int i = 0; i<pt; i++)
					System.out.print(" ");
				System.out.println("|");
				System.out.print("  ");
				for(int i = 0; i<pt-pp; i++)
					System.out.print(" ");
				System.out.println(pat+"\n");
				pt = pt-pp+1;
				pp = 0;
				count++;
			}
		}
		System.out.println("비교는 "+(count+pp)+"회 하였습니다.");
		if(pp == pat.length())
			return pt - pp;
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("텍스트 : ");
		String s1 = in.next();
		
		System.out.print("패턴 : ");
		String s2 = in.next();
		
		int idx = bfMatch(s1, s2); //s1에서 s2를 검색
		
		if(idx == -1)
			System.out.println("텍스트에 패턴이 없습니다.");
		else {
			int len = 0;
			for(int i = 0; i< idx; i++)
				len += s1.substring(i, i+1).getBytes().length;
			len += s2.length();
			
			System.out.println((idx+1) + "번째 문자부터 일치합니다.");
			System.out.println("텍스트 : "+s1);
			System.out.printf(String.format("패턴 : %%%ds\n", len), s2);
		}
	}
}
