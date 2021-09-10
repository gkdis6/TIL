package day08;

class RunThread4 extends Thread {
	public RunThread4(String name) {
		super(name);
	}

	public void run() {
		for (int i = 1; i <= 10000; i++) {
			if (i % 50 == 0)
				System.out.println("Thread [" + getName() + "] : " + i);

			try {
				sleep(1); // 0.001초
			} catch (InterruptedException e) {
			}

		}
	}
}

public class SchedulingTest4 {
	public static void main(String args[]) {
		Thread[] t = new RunThread4[3];
		t[0] = new RunThread4("☆");
		t[1] = new RunThread4("◑");
		t[2] = new RunThread4("○");
		t[0].start();
		t[0].setPriority(1);
		t[1].start();
		t[1].setPriority(5);
		t[2].start();
		t[2].setPriority(10);
		
//		 System.out.println("t[0]" + t[0].getPriority()); System.out.println("t[1]" +
//		 t[1].getPriority()); System.out.println("t[2]" + t[2].getPriority());
	 
	}
}
