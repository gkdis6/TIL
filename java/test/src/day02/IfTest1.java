package day02;

public class IfTest1 {

	public static void main(String[] args) {
		int i = 120;
		
		if(i%2 == 0) {
			int count = 1;
			System.out.println(i+"은(는) 짝수");
		}
		
		//System.out.println("count : "+count);
		
		if (i % 2 == 0) {
			System.out.println("짝수 " + i); // 참
		} else {
			System.out.println("홀수 " + i); // 거짓
		}
		
		if(i%3 == 0) {
			System.out.println("3의 배수");
		}else if(i%4 == 0) {
			System.out.println("4의 배수");
		}else if(i%7 == 0) {
			System.out.println("7의 배수");
		}else {
			System.out.println("3, 4, 7의 배수가 아닙니다.");
		}
		
	}

}
