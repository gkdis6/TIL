package day04;

class ScjpPass {
	// 멤버 변수, Heap
	int t1 = 0;
	int t2 = 0;
	int t3 = 0;
	int t4 = 0;

	// 클래스 변수, Data area
	static int BONUS = 100;

	// 생성자, Source area
	public ScjpPass() {
	}

	// 생성자, this = sp객체가 가지고 있는 hash code
	// sp객체의 heap메모리를 공유하게됩니다.
	// int t1, int t2, int t3, int t4: Stack
	public ScjpPass(int t1, int t2, int t3, int t4) {
		// Heap = Stack
		// 전역 변수 = 지역 변수
		// 멤버 변수 = 지역 변수
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
	}

}

public class Scjp {
	public static void main(String[] args) {
		System.out.println("ScjpPass.BONUS: " + ScjpPass.BONUS);

		// t1은 static이 아님으로 클래스명으로 접근 할 수 없습니다.
		// System.out.println(ScjpPass.t1);
		// heap memory 할당
		ScjpPass sp = new ScjpPass(85, 90, 80, 70);
		System.out.println("sp.t1: " + sp.t1);
		// static변수는 클래스명으로 접근을 권장합니다.
		// System.out.println("sp.BONUS: " + sp.BONUS);
	}
}
