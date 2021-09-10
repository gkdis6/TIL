package day04;

class School3 {
	int kuk = 0;
	int eng = 0;
	int tot = 0;

	public School3() {

	}

	public int hap() {
		tot = kuk + eng;

		return tot;
	}
}

public class SchoolMain3 {

	public static void main(String[] args) {
		School3 sc3 = new School3();
		sc3.kuk = 90;
		sc3.eng = 100;
		System.out.println("hap: " + sc3.hap());
	}
}
