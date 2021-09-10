package day03_code;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		String s = "Hello World! 3+3.0-6";
		
		Scanner scanner = new Scanner(s);
		
		System.out.println("" + scanner.hasNext());
		
		System.out.println("" + scanner.nextLine());
		
		System.out.println("" + scanner.hasNext());
		
		scanner.close();

	}

}
