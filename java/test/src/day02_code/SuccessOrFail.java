package day02_code;

import java.util.Scanner;

public class SuccessOrFail {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); // 키보드로 입력된 값을 관리

		System.out.print("점수를 입력하시오: ");
		int score = in.nextInt();
		if (score >= 80)
			System.out.println("축하합니다! 합격입니다.");
	}

}
