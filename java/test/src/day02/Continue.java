package day02;

public class Continue {
	public static void main(String[] args) {

		for (int i = 0; i <= 2; i++) {
			// ┌ continue시 이동되는 곳
			// ↓
			for (int j = 0; j <= 2; j++) {
				if (i == j) {
					continue;
				}
				System.out.println("i==" + i + " j==" + j);

			}
		}
	}
}
