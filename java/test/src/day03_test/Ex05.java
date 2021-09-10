package day03_test;

public class Ex05 {

	public static void main(String[] args) {
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int max = (n1 >= n2)? n1 : n2;
		int min = (n1 <= n2)? n1 : n2;
		
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
	}

}
