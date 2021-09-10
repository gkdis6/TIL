package day02_code;

import java.util.Scanner;

public class Grading {
	public static void main(String[] args) {
		char grade;
		Scanner a = new Scanner(System.in);// 키보드 입력값
		while (a.hasNext()) { // 입력된 값이 있을 동안 반복
			int score = a.nextInt();
			if (score >= 90.0) // socre가 90.0 이상인 경우
				grade = 'A';
			else if (score >= 80.0) // score가 80.0 이상이면서 90.0 미만인 경우
				grade = 'B';
			else if (score >= 70.0) // score가 70.0 이상이면서 80.0 이만인 경우
				grade = 'C';
			else if (score >= 60.0) // score가 60.0 이상이면서 70.0 이만인 경우
				grade = 'D';
			else // score가 60.0 이만인 경우
				grade = 'F';
			System.out.println("학점은 " + grade + "입니다");
		}
	}
}
