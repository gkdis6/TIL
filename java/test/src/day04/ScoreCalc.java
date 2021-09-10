package day04;

class Score {
	// 이름 국어 영어 수학 총점 평균
	private String name;
	private int kuk;
	private int eng;
	private int math;

	public Score() {
	}

	public Score(String str, int n1, int n2, int n3) {
		name = str;
		kuk = n1;
		eng = n2;
		math = n3;
	}

	public void setName(String str) {
		name = str;
	}

	public String getName() {
		return name;
	}

	public void setkuk(int n) {
		kuk = n;
	}

	public int getkuk() {
		return kuk;
	}

	public void seteng(int n) {
		eng = n;
	}

	public int geteng() {
		return eng;
	}

	public void setmath(int n) {
		math = n;
	}

	public int getmath() {
		return math;
	}

	public int total() {
		return kuk + eng + math;
	}

	public double avg() {
		return total() / 3;
	}

	public void printScore() {
		System.out.println("--------------------");
		System.out.println("---- " + name + " 시험 ----");
		System.out.println("--------------------");
		System.out.println("성명 : " + name);
		System.out.println("국어점수 : " + kuk);
		System.out.println("영어점수 : " + eng);
		System.out.println("수학점수 : " + math);
		System.out.println("합계 : " + total());
		System.out.println("평균 : " + avg());
		System.out.println();
	}

}

class Grade extends Score {

	public Grade() {
	}

	public Grade(String str, int n1, int n2, int n3) {
		super(str, n1, n2, n3);
	}

	public String getGrade(Double avg) {
		String grade = null;
		switch ((int) (avg / 10)) {
		case 10, 9, 8:
			grade = "A";
			break;
		case 7, 6:
			grade = "B";
			break;
		case 5, 4:
			grade = "C";
			break;
		case 3, 2, 1:
			grade = "F";
			break;
		default:
			return "0";
		}
		return grade;
	}

	public void printScore() {
		System.out.println("--------------------");
		System.out.println("---- " + getName() + " 시험 ----");
		System.out.println("--------------------");
		System.out.println("성명 : " + getName());
		System.out.println("국어점수 : " + getkuk());
		System.out.println("영어점수 : " + geteng());
		System.out.println("수학점수 : " + getmath());
		System.out.println("합계 : " + total());
		System.out.println("평균 : " + avg());
		System.out.println("등급 : " + getGrade(avg()));
		System.out.println();
	}

}

public class ScoreCalc {

	public static void main(String[] args) {
		// score 객체 3개 생성

		Score m1 = new Score("박상용", 92, 86, 100);
		Score m2 = new Score("문주현", 96, 100, 85);
		Score m3 = new Score("송광석", 88, 80, 50);

		m1.printScore();

		m2.printScore();

		m3.printScore();

		// grade
		Grade g1 = new Grade();
		g1.setName("주현");
		g1.seteng(100);
		g1.setkuk(99);
		g1.setmath(70);
		Grade g2 = new Grade("상용", 99, 80, 100);

		g1.printScore();
		g2.printScore();
	}

}
