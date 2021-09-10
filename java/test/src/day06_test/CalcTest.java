package day06_test;

abstract class Calculator {
	public abstract int add(int a, int b);

	public abstract int subtract(int a, int b);

	public abstract double average(int[] a);
}

class GoodCalc extends Calculator {
	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		return a - b;
	}

	@Override
	public double average(int[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum / a.length;
	}
}

public class CalcTest {

	public static void main(String[] args) {
		GoodCalc gc = new GoodCalc();
		int[] ar = { 15, 36, 65, 63 };

		System.out.println(gc.add(30, 25));
		System.out.println(gc.subtract(43, 8));
		System.out.println(gc.average(ar));

	}

}
