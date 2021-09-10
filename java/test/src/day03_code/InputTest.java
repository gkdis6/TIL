package day03_code;

import java.util.Scanner;

class InputTest {
	public static void main(String[] args) {
		// 입력 기능, System.in: 키보드, Scanner: 1.5부터 사용
		Scanner in = new Scanner(System.in);

		System.out.print("문자열 입력: ");
		String dest = in.next(); // 문자열 입력

		System.out.print("정수 입력: ");
		int money = in.nextInt(); // 정수 입력

		System.out.print("float 실수 입력(f를 포함하지 말것): ");
		float f = in.nextFloat(); // 실수 입력

		System.out.print("double 실수 입력: ");
		double d = in.nextDouble(); // double 실수 입력

		System.out.println("----------------------------------");
		System.out.println("입력된 문자열: " + dest);
		System.out.println("입력된 정수: " + money);
		System.out.println("입력된 float 실수: " + f);
		System.out.println("입력된 dobue 실수: " + d);
	}
}
