import java.io.FileWriter;
import java.io.IOException;

public class OtherOOP {

	public static void main(String[] args) throws IOException {
		System.out.println(Math.PI);
		System.out.println(Math.floor(1.8));
		System.out.println(Math.ceil(1.8));
		
		FileWriter t1 = new FileWriter("data.txt");
		t1.write("Hello");
		t1.write(" Java");
		t1.close();
	}
	public int minus(int i, int j) {
		return i-j;
	}

}

//extends
class cal extends OtherOOP{
	//이렇게 상속받을 수 있음
	public int sum(int i, int j) {
		return i+j;
	}
	//overloading
	public int sum(int i, int j, int k) {
		return i+j+k;
	}
	public int minus(int i, int j) {
		return super.minus(i, j); //super로 부모의 method를 불러올 수 있다.
	}
	ab2 a = new ab2(3, 4);

}

class ab {
	int i, j;
	ab(int i, int j){
		this.i = i;
		this.j = j;
	}
}

class ab2 extends ab{
	ab2(int i, int j){
		super(i, j);
		System.out.println("ab2 init");
	}
}

/*interface는 implements로 받을 수 있고 선언한 메소드들을 직접 정의해줘야 함 
interface m2{
	public String method12(String param);
	public int method2(int param);
}

class Concreate1 implements m2{
	public String method12(String param) {
		return "foo";
	}
	public int method2(int param) {
		return 32;
	}
}*/
