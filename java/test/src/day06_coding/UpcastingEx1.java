package day06_coding;

class Person1 {
	String name;
	String id;

	public Person1(String name) {
		this.name = name;
	}
}

class Student1 extends Person1 {
	String grade;
	String department;

	public Student1(String name) {
		super(name);
	}
}

public class UpcastingEx1 {
	public static void main(String[] args) {
		Person1 p;
		Student1 s = new Student1("이재문");
		p = s; // 업캐스팅 발생
		System.out.println(p.name); // 오류없음
		//p.grade = "A"; // 컴파일(오류
		//p.department = "Com"; // 컴파일(오류
	}
}
