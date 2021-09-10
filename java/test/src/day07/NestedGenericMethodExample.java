package day07;

class GenericClass2<T> {
	public void printMethodArgInfo(T arg) {
		System.out.print("Argument Type is " + arg.getClass());
		System.out.println(" / Value is " + arg.toString());
	}

	public <T> void printGenericMethodArgInfo(T arg) {
		System.out.print("Argument Type is " + arg.getClass());
		System.out.println(" / Value is " + arg.toString());
	}
}

public class NestedGenericMethodExample {
	public static void main(String[] args) {
		GenericClass2<String> gc = new GenericClass2<String>();
		gc.printGenericMethodArgInfo(10L);
		gc.printGenericMethodArgInfo('A');
//gc.printMethodArgInfo(10L); // error 
	}
}
