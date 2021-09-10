package day02_code;

import java.util.Scanner;

public class MultipleOfThree {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); // 키보드 입력값

		System.out.print("수를 입력하시오: ");
		int number = in.nextInt();
		if (number % 3 == 0) // 3으로 나눈 나머지가 0인지 검사
			System.out.println("3의 배수입니다.");
		else
			System.out.println("3의 배수가 아닙니다.");
	}
}
