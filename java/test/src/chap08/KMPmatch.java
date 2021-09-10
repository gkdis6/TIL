package chap08;

import java.util.Scanner;

public class KMPmatch {

	static int kmpMatch(String txt, String pat) {
		int pt = 1;
		int pp = 0;
		int[] skip = new int[pat.length()+1];
		
		skip[pt] = 0;
		while(pt != pat.length()) {
			if(pat.charAt(pt) == pat.charAt(pp))
				skip[++pt] = ++pp;
			else if(pp == 0)
				skip[++pt] = pp;
			else
				pp=skip[pp];
		}
		
		pt = pp = 0;
		while(pt != txt.length() && pp != pat.length()) {
			if(txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			}else if(pp == 0)
				pt++;
			else
				pp = skip[pp];
		}
		
		if(pp == pat.length())
			return pt-pp;
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("텍스트 : ");
		String s1 = in.next();
		
		System.out.print("패턴 : ");
		String s2 = in.next();
		
		if(kmpMatch(s1, s2) == -1)
			System.out.println("텍스트 안에 패턴이 없습니다.");
		else {
			System.out.println("텍스트 : "+s1);
			System.out.println("패턴 : "+s2);
			System.out.println(kmpMatch(s1, s2)+"번째에 있습니다.");
		}
		
		
	}

}
