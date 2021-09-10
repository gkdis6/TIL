package day06_coding;

class Person {
	String phone;

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}
}

class Professor extends Person {
	public String getPhone() { // Person의 getPhone()을 오버라이딩
		return "Professor : " + super.getPhone(); // Person의 getPhone() 호출
	}
}

public class Overriding {
	public static void main(String[] args) {
		Professor a = new Professor();
		a.setPhone("011-123-1234"); // Professor의 getPhone() 호출
		System.out.println(a.getPhone());

		Person p = a;
		System.out.println(p.getPhone()); // 동적 바인딩에 의해
// Professor의 getPhone() 호출
	}
}