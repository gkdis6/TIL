package day03_test;

import java.util.Calendar;

public class Ex04 {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		int age = 1 + calendar.get(Calendar.YEAR) - (1900 + Integer.parseInt(args[3].substring(0,2)));
		
		System.out.println("이름 : "+args[0]);
		System.out.println("전화번호 : "+args[1]);
		System.out.println("주소 : "+args[2]);
		System.out.println("나이 : "+age);
	}
}
