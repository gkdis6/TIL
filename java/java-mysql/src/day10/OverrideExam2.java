package day10;

class OverB{
	void show() {
		System.out.println("부모클래스의 메소드의 show");
	}
	
	void parent() {
		System.out.println("부모클래스에만 있는 메소드 parent()");
	}
}

class SubOverB extends OverB{

	@Override
	void show() {
		System.out.println("자식클래스의 메소드 show()");
	}
	
}


public class OverrideExam2 {

	public static void main(String[] args) {
		SubOverB sb = new SubOverB();
		
		sb.show();
		sb.parent();
		
		OverB over = new OverB();
		
		over.show();
		over.parent();
		
		OverB o = new SubOverB();
		o.show();
		o.parent();

	}

}
