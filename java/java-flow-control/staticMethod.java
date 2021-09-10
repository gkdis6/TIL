
public class staticMethod {

	public static void main(String[] args) {
		// t1이 instance
		Print t1 = new Print();
		t1.delimiter = "-";
		t1.a(); //이 method가 class 소속이면 static이 붙어야 하고 이 상황에선 instance의 소속이기 때문에 static이 빠져야 한다.
		t1.b();
	}


}
class Print {
	public String delimiter;
	public void a() {
		System.out.println(this.delimiter);
		System.out.println("a");
		System.out.println("a");
	}
	public void b() {
		System.out.println(this.delimiter);
		System.out.println("b");
		System.out.println("b");
	}
}