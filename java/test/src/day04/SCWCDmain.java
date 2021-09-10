package day04;

class SCWCD {
	int t1 = 0;
	int t2 = 0;
	int t3 = 0;
	int t4 = 0;
	static int BONUS = 100;

	public SCWCD() {
	}

	public SCWCD(int t1, int t2, int t3, int t4) {
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
	}

	// 클래스 메소드
	public static void prLine() {
		System.out.println("****************");
		System.out.println("   SOLDESK       ");
		System.out.println("         JAVA   ");
		System.out.println("****************");
	}
}

public class SCWCDmain {
	public static void main(String[] args) {
		// 클래스.static 메소드명
		System.out.println(SCWCD.BONUS);
		SCWCD.prLine();
	}
}
