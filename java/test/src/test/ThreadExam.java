package test;

public class ThreadExam {

	public static void main(String[] args) {
		MyThread mt = new MyThread("+");
		MyThread mt2 = new MyThread("=");
		
		mt.start();
		mt2.start();
		
		System.out.println("main end !!!");
	}

}
