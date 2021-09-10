package day08;

class ThreadOne implements Runnable {
	private int num;
	private String name;

	public ThreadOne(String a, int b) {
		name = a;
		num = b;
	}

	public void run() {
		for (int i = 0; i < num; i++)
			System.out.println(name + " : " + i);
	}
}

public class ThreadTest2 {
	public static void main(String args[]) {
		// Runnable Interface를 구현한 클래스 객체를
		// Thread 클래스의 생성자로 할당합니다.
		Thread t1 = new Thread(new ThreadOne("first", 1000));
		Thread t2 = new Thread(new ThreadOne("second", 1000));
		Thread t3 = new Thread(new ThreadOne("third", 1000));
		t1.start();
		t2.start();
		t3.start();
	}
}