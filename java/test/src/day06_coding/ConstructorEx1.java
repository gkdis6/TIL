package day06_coding;

class A1 {
	public A1(int x) {
		System.out.println("생성자A");
	}
	public A1() {
	}
}

class B1 extends A1 {
	public B1() {
		//super(10);
		System.out.println("생성자B");
	}
}

public class ConstructorEx1 {
	public static void main(String[] args) {
		B1 b;
		b = new B1();
	}
}
