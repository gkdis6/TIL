package day08;

interface PrintString {

	void showString(String str);
}

public class TestLambda {

	public static void main(String[] args) {

		PrintString lambdaStr = s -> System.out.println(s); // 람다식을 변수에 대입
		lambdaStr.showString("hello lambda_1");

		showMyString(lambdaStr);
		
		PrintString reStr = returnString();
		reStr.showString("hello ");
	}
	
	public static void showMyString(PrintString p) {
		p.showString("hello lambda_2");
	}
	
	public static PrintString returnString() {
		return s -> System.out.println(s + "world");
	}
}
