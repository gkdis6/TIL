package day05;

class Person {
	String name;
	String id;

	public Person(String name) {
		this.name = name;
	}
}

class Student extends Person {
	String grade;
	String department;

	public Student(String name) {
		super(name);
	}
}

public class UpcastingEx {

	public static void main(String[] args) {
		Person p;
		Student s = new Student("홍길동");
		p = s;
		System.out.println(p.name);

//		p.grade = "A";
//		p.department = "Com";

		Student s2 = (Student) p;
		s2.grade = "A";
		s2.department = "Com";
		System.out.println(s2.name);

		System.out.println("==== 해쉬코드 ====");
		System.out.println("자식 타입 : " + s.hashCode());
		System.out.println("부모 타입 : " + p.hashCode());
		System.out.println("다운 캐스팅한 자식 타입 : " + s2.hashCode());
		
//		Student s3 = (Student) new Person("아롬이"); //new를 쓰면 부모객채만 만들어짐
//		System.out.println(s3);

	}

}
