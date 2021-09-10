package day02_code;

public class DosInput2 {

	public static void main(String[] args) {
		int i1 = Integer.parseInt(args[0]); // 1번째 수
		int i2 = Integer.parseInt(args[1]); // 2번째 수

		System.out.println("args.length:" + args.length);
		System.out.println("i1:" + i1);
		System.out.println("i2:" + i2);
		System.out.println("i1+i2:" + (i1 + i2));
	}

}