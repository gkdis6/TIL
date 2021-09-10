package day03_test;

public class Ex06 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		
		if(num>0) System.out.println("입력된 숫자는 양수입니다.");
		if(num<0) System.out.println("입력된 숫자는 음수입니다.");
		if(num==0) System.out.println("입력된 숫자는 0입니다.");

	}

}
