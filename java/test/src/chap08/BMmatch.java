package chap08;

import java.util.Scanner;

public class BMmatch {

	static int bmMatch(String txt, String pat) {
		int pt;
		int pp;
		int txtLen = txt.length();
		int patLen = pat.length();
		int[] skip = new int[Character.MAX_VALUE + 1];
		
		for(pt = 0; pt<= Character.MAX_VALUE; pt++)
			skip[pt] = patLen;
		for(pt = 0; pt< patLen -1; pt++) {
			skip[pat.charAt(pt)] = patLen - pt -1;
			System.out.println(pat.charAt(pt));
		}
		while(pt < txtLen) {
			pp = patLen -1;
			
			while (txt.charAt(pt) == pat.charAt(pp)) {
				if(pp == 0)
					return pt;
				pp--;
				pt--;
			}
			pt+= (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen-pp;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("텍스트 : ");
		String s1 = in.next();
		
		System.out.print("패턴 : ");
		String s2 = in.next();
		
		if(bmMatch(s1, s2) == -1)
			System.out.println("텍스트 안에 패턴이 없습니다.");
		else {
			System.out.println("텍스트 : "+s1);
			System.out.println("패턴 : "+s2);
			System.out.println(bmMatch(s1, s2)+"번째에 있습니다.");
		}
	}

}
