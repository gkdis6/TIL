package test;

import java.util.ArrayList;

public class hy {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("Hello jump to java");
		System.out.println(sb.substring(0,4));
		
		ArrayList aList = new ArrayList();
		aList.add("hello");
		aList.add("java");
		aList.add("1234");
		
		String hello = (String) aList.get(0);
		String java = (String) aList.get(1);
		int gi = Integer.parseInt(aList.get(2).toString());
		
		System.out.println(hello);
		System.out.println(java);
		System.out.println(gi);
		
		sb.insert(0, gi);
		int gg =  Integer.parseInt(sb.substring(0, 4));
		
		System.out.println(gg);
		
    }
}