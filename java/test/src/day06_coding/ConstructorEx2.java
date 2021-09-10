package day06_coding;

class A2{
	public A2() {
		System.out.println("생성자A");
	}
	public A2(int x) {
		System.out.println("매개변수 생성자A");
	}
}

class B2 extends A2{
	public B2() {
		System.out.println("생성자B");
	}
	public B2(int x) {
		System.out.println("매개변수 생성자B");
	}
}

public class ConstructorEx2 {

	public static void main(String[] args) {
		B2 b;
		b = new B2(5);

	}

}
