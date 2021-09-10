package day07;

class Price<N, V> {
	private N[] names;
	private V[] values;
	private int index;

	Price(int size) {
		names = (N[]) new Object[size];
		values = (V[]) new Object[size];
		index = 0;
	}

	public void insert(N n, V v) {
		names[index] = n;
		values[index] = v;
		++index;
	}

	public void print() {
		for (int i = 0; i < index; i++)
			System.out.println(names[i] + " : " + values[i]);
	}
}

public class MultipleTypeParam {
	public static void main(String[] args) {
		Price<String, Integer> p1 = new Price<String, Integer>(10);
		Price<String, Double> p2 = new Price<String, Double>(10);
		p1.insert("Apple", 1200);
		p1.insert("Banana", 2000);
		p1.insert("Grape", 4500);
		p2.insert("USD", 943.0);
		p2.insert("JPY", 822.86);
		p2.insert("EUR", 1273.05);
		System.out.println("*** Fruit Price ***");
		p1.print();
		System.out.println("*** Exchange Rate ***");
		p2.print();
	}
}
