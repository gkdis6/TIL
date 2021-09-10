package day06;

public class Ex2 {

	public static void main(String[] args) {
		try {

			String str = "홍";

			char c = str.charAt(1);

			System.out.println(c);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("무조건 실행");
		}

		System.out.println("프로그램이 정상적으로 종료됩니다.");

	}

}
