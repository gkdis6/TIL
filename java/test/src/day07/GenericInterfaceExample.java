package day07;

interface GenericInterface<T> {
	public void setValue(T x);

	public String getValueType();
}

class GenericClass<T> implements GenericInterface<T> {
	private T value;

	public void setValue(T x) {
		value = x;
	}

	public String getValueType() {
		return value.getClass().toString();
	}
}

public class GenericInterfaceExample {
	public static void main(String[] args) {
		GenericClass<Integer> gInteger = new GenericClass<Integer>();
		GenericClass<String> gString = new GenericClass<String>();
		gInteger.setValue(10);
		gString.setValue("Text");
		System.out.println(gInteger.getValueType());
		System.out.println(gString.getValueType());
	}
}