package day05_test;

class Person {
	String name;
	String phone;
	static int ID;

	public void setName(String s) {
		name = s;
	}

	public String getPhone() {
		return phone;
	}

	public static int getID() {
		return ID;
	}
}


public class Professor extends Person{


	public void setName(String s) { //property가 좁아짐
	}

	public String getPhone() { //아래에 이름, 인자가 없는 것까지 동일한 메소드가 존재함. 그래서 구별할 수 없음.
		return phone;
	}

//	public void getPhone() { 주석 처리
//	}

//	public int getID() { 부모에서 static이기 때문에 overriding이 불가능함
//	}
	
	public static void main(String[] args) {

	}

}
