package day03_test;

import java.util.Calendar;
import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Calendar calendar = Calendar.getInstance();
		
		System.out.print("이름을 입력해주세요. ");
		String str = in.nextLine();
		
		//in.nextLine();
		System.out.println("주소를 입력해주세요. ");
		String str2 = in.nextLine();
		
		
		System.out.print("생일을 입력해주세요. (YYYY.MM,DD) ");
		int age = 1 + calendar.get(Calendar.YEAR) - (Integer.parseInt(in.nextLine().substring(0,4)));
		
		System.out.println("이름 : "+str);
		System.out.println("주소 : "+str2);
		System.out.println("나이 : "+age);
	}

}
