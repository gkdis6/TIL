package day06;

public class Constant {
	public static final int COUNT = 1;

	public void prn() {
		// COUNT = 5;
		for (int i = 0; i < COUNT; i++) {
			System.out.print("JAVA ");
		}

		for (int i = 0; i < COUNT; i++) {
			System.out.print("JSP ");
		}

		for (int i = 0; i < COUNT; i++) {
			System.out.print("EJB ");
		}

		for (int i = 0; i < COUNT; i++) {
			System.out.print("CBD Oracle OJT ");
		}
	}

	public static void main(String[] args) {
		Constant constant = new Constant();
		constant.prn();

		for (int i = 0; i < Constant.COUNT; i++) {
			System.out.print("Struts ");
		}

	}

}
