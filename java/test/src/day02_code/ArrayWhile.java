package day02_code;

public class ArrayWhile {

	public static void main(String[] args) {
		String[] movies = { "그래비티", "맘마 미아", "레미제라블", "월터의 상상은 현실이 된다.", "노아", "엣지 오브 투모로우", "트랜센던스", "X-MAN" };

		int cnt = -1;

		System.out.println("배열의 값의 갯수: " + movies.length); // 8
		while (true) {
			cnt = cnt + 1;
			System.out.println(movies[cnt]); // 0 ~ 7

			if (cnt == movies.length - 1) { // 7
				break;
			}
		}
	}

}
