package day03;

public class Test01 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) { // 위에부분
			for (int j = 1; j < i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		for (int i = 1; i <= 6; i++) { // 아래 부분
			if (i > 1) {
				for (int j = 0; j < i - 1; j++) {
					System.out.print(" ");
				}
			}
			for (int j = 1; j <= (6 - i); j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}