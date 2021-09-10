package day04;

class School2 {
	int kuk = 0;
	int eng = 0;
	int tot = 0;

	public int hap() {
		tot = kuk + eng;

		return tot;
	}
}

public class SchoolMain2 {

	public static void main(String[] args) {
		School2 sc2 = new School2();
		sc2.kuk = 90;
		sc2.eng = 100;
		System.out.println("hap: " + sc2.hap());
	}
}
