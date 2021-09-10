package day06_coding;

class Rect2 {
	int width;
	int height;

	public Rect2(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public boolean equals(Rect2 p) {
		if (width * height == p.width * p.height) // 사각형 면적 비교
			return true;
		else
			return false;
	}
}

public class EqualsEx {
	public static void main(String[] args) {
		Rect2 a = new Rect2(2, 3);
		Rect2 b = new Rect2(3, 2);
		Rect2 c = new Rect2(3, 4);
		if (a.equals(b))
			System.out.println("a is equal to b");
		if (a.equals(c))
			System.out.println("a is equal to c");
		if (b.equals(c))
			System.out.println("b is equal to c");
	}
}