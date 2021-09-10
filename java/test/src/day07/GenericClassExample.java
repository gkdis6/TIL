package day07;

class SimpleGeneric<E> {
	private E[] values;
	private int index;

	SimpleGeneric(int len) { // Constructor
		values = (E[]) new Object[len];
		index = 0;
	}

	public void add(E ... args) {
		for (E e : args)
			values[index++] = e;
	}

	public void print() {
		for (E e : values)
			System.out.print(e + " ");
		System.out.println();
	}
}

public class GenericClassExample {
	public static void main(String[] args) {
		SimpleGeneric<Integer> gInteger = new SimpleGeneric<Integer>(10);
		SimpleGeneric<Double> gDouble = new SimpleGeneric<Double>(10);
		gInteger.add(1, 2);
		gInteger.add(1, 2, 3, 4, 5, 6, 7);
		gInteger.add(0);
		gInteger.print();
		gDouble.add(10.0, 20.0, 30.0);
		gDouble.print();
	}
}
