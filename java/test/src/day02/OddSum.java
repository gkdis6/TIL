package day02;

public class OddSum {
	public static void main(String[] args) {
		int sum = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				sum += i;
			}
		}

		System.out.println("1~100까지 수의 합:" + sum);

	}

}

