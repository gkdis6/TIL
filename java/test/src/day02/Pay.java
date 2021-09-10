package day02;

public class Pay {
	public static void main(String[] args) {
		int year = 5; // 근무(경력) 년수
		int child = 0; // 자녀수
		int pay = 1500000; // 초봉 기본급

		if (year == 0) {
			System.out.println("신입사원입니다.");
		} else if (year == 1) {
			pay += 200000*year;
			System.out.println("경력 1년 입니다.");
		} else if (year == 2) {
			pay += 200000*year;
		} else if (year == 3) {
			pay += 200000*year;
		} else if (year == 4) {
			pay += 200000*year;
		} else {
			pay += 1500000;
		}

		// 자녀수당을 계산합니다.
		if (year >= 1) {
			if (child > 1) pay += (child * 200000);
		}

		System.out.println("기본급: " + pay);
		System.out.println("연  봉: " + (pay * 13));
		System.out.println("월급여: " + ((pay * 13) / 12));
	}
}