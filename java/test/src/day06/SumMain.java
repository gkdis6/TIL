package day06;

abstract class Sum {
	public abstract String toString();

	public String sum(int i, int j) {
		int sum = i + j;
		return "" + sum;
	}
}

class Sum_s1 extends Sum {
	@Override
	public String toString() {
		return "class Sum_s1 extends Sum";
	}
}

class Sum_s2 extends Sum {
	@Override
	public String toString() {
		return "class Sum+s2 extends Sum";
	}
}

public class SumMain {

	public static void main(String[] args) {
		Sum_s1 s1 = new Sum_s1();
		System.out.println(s1.sum(10, 20));
		System.out.println(s1.toString());

		Sum_s2 s2 = new Sum_s2();
		System.out.println(s2.sum(100, 200));
		System.out.println(s2.toString());

	}

}
