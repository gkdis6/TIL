package day08;

class SleepThread extends Thread {
	public SleepThread(String name) {
		setName(name);
	}

	public void run() {
		show();
	}

	public void show() {
		for (int i = 0; i < 50; i++) {
			print();
			try {
				Thread.sleep(50);// 50/1000 초
			} catch (InterruptedException ite) {
			}
		}
	}

	public void print() {
		System.out.print(getName());// Thread에서
	}
}

public class SleepThreadMain {
	public static void main(String[] args) {
		SleepThread t1 = new SleepThread("a");
		SleepThread t2 = new SleepThread("b");
		SleepThread t3 = new SleepThread("c");
		t2.setPriority(7);// 1~10 클수록 우선순의 높음
		t1.start();// t2가 t1보다 우선이지만
		try {
			t1.join();// t1을 끝낸후 t2, t3를 실행한다.
		} catch (InterruptedException ite) {
		}
		t2.start();
		t3.start();
	}
}
