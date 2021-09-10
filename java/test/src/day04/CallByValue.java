package day04;

class Person{
	String name;
	int age;
	
	Person(String s){
		name = s;
	}
	
	public void setAge(int n) {
		age = n;
		n++;
	}
}

public class CallByValue {

	public static void main(String[] args) {
		Person p = new Person("박상용");
		int a = 33;
		
		p.setAge(a);
		
		System.out.println(a);
	}

}
