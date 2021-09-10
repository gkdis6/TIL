package day02_code;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("나이, 체중, 신장을 빈칸으로 분리하여 순서대로 입력하세요");
		System.out.println("당신의 나이는 " + in.nextInt() + "살 입니다.");
		System.out.println("당신의 체중은 " + in.nextDouble() + "kg 입니다.");
		System.out.println("당신의 신장은 " + in.nextDouble() + "cm 입니다.");
	}

}
