package day03;

public class Test02 {
	public static void main(String[] args) {
// 로또 만들기
		int a[] = new int[10];
		System.out.print("로또 번호 : ");
		for (int i = 1; i <= 6; i++) {
			a[i] = (int) (Math.random() * 45 + 1); // 배열에 난수 저장
			System.out.print(a[i] + "  ");
		}
	}
}
