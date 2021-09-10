package day04;

class School4 {
	int kuk = 0;
	int eng = 0;
	int tot = 0;

	// 기본 생성자
	public School4() {
	}

	// 아래처럼 인수를 받는 생성자가 존재하면
	// 반드시 기본 생성자를 명시적으로 선언해야 합니다.
	public School4(int kuk, int eng) {
		this.kuk = kuk;
		this.eng = eng;
	}

	public int hap() {
		tot = kuk + eng;

		return tot;
	}
}

public class SchoolMain4 {

	public static void main(String[] args) {
		School4 sc4 = new School4();
		sc4.kuk = 90;
		sc4.eng = 100;
		System.out.println("hap: " + sc4.hap());

		School4 sc = new School4(90, 100);
		System.out.println("hap: " + sc.hap());
	}
}
