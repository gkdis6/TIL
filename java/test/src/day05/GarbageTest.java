package day05;

class Garbage {

	int objNo;

	public Garbage(int n) {
		objNo = n;
		System.out.println("Garbage class " + objNo + " 이 만들어 졌습니다.");
	}

	// 객체의 메모리가 회수 될때에 자동으로 호출됩니다.
	protected void finalize() throws Throwable {
		System.out.println("Garbage class " + objNo + " 에서 쓰이던 메모리가 수집되었습니다.");
		super.finalize();
	}
}

public class GarbageTest {

	public static void main(String[] args) {

		Garbage[] ga = new Garbage[10];

		// 객체 생성
		for (int i = 0; i < ga.length; i++) {
			ga[i] = new Garbage(i);
		}

		// 객체 메모리 해제
		for (int i = 0; i < ga.length; i++) {
			ga[i] = null;// 메모리 회수의 대상이 됩니다.
		}

		// 강제로 가베지컬렉션 기능 수행
		System.gc();
	}
}
