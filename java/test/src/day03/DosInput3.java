package day03;

import java.text.DecimalFormat;

public class DosInput3 {

	public static void main(String[] args) {
		DecimalFormat comma = new DecimalFormat("###,##0");
		String cs1;
		String cs2;
		
		String s1 = args[0];
		
		int i1 = Integer.parseInt(args[1]);
		cs1 = comma.format(i1);
		
		int i2 = Integer.parseInt(args[2]);
		cs2 = comma.format(i2);
		
		System.out.println("args.length : "+args.length);
		System.out.println("성명(name) : "+s1);
		System.out.println("급여(pay) : "+cs1);
		System.out.println("세금(tax) : "+cs2);
		System.out.println("실수령액(income) : "+comma.format(i1-i2));

	}

}
