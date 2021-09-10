package day04;

public class Order {
	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		int mainb = 0; // 메인보드
		int cpu = 0; // CPU
		int ram = 0; // RAM
		int hdd = 0; // HDD
		int pcase = 0; // 케이스
		int sum = 0; // 부속의 합
		int gong = 100000; // 공인비
		int delivery = 20000; // 택배비
		int tot = 0; // 총금액
		int tax = 0; // 부가가치세
		int pay = 0; // 결재금액
		String sang = ""; // 상품권

		System.out.println("가격을 입력하세요. ");
		System.out.println("-------------------");
		System.out.print("Main Board: ");
		mainb = in.nextInt();
		System.out.print("CPU       : ");
		cpu = in.nextInt();
		System.out.print("RAM       : ");
		ram = in.nextInt();
		System.out.print("HDD       : ");
		hdd = in.nextInt();
		System.out.print("외장 케이스: ");
		pcase = in.nextInt();

		sum = mainb + cpu + ram + hdd + pcase;
		tot = sum + gong + delivery;
		tax = (int) (tot * 0.1); // 세금
		pay = tot + tax; // 결재 금액

		if (pay < 500000) {
			sang = "5 천원";
		} else if (pay >= 500000 && pay < 600000) {
			sang = "1 만원";
		} else if (pay >= 600000 && pay < 700000) {
			sang = "2 만원";
		} else {
			sang = "3 만원";
		}

		System.out.println();
		System.out.println("-------------------");
		System.out.println("    견적 내역서    ");
		System.out.println("-------------------");
		System.out.println("Main Board: " + mainb);
		System.out.println("CPU: " + cpu);
		System.out.println("RAM: " + ram);
		System.out.println("HDD: " + hdd);
		System.out.println("Case: " + pcase);
		System.out.println("부속 금액: " + sum);
		System.out.println("공인비: " + gong);
		System.out.println("택배비: " + delivery);
		System.out.println("총금액: " + tot);
		System.out.println("부가가치세: " + tax);
		System.out.println("결재금액: " + pay);
		System.out.println("상품권 증정: " + sang);

	}

}
