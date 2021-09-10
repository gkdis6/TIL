package day06;

class UserException {
	public UserException() {
	}

	public UserException(Exception e) {
		// super(message);
		System.out.println("-------------------------------------------------");
		System.out.println("파일에 에러 내역을 기록합니다......");
		System.out.println("☞ 에러원인: " + e.toString());
		System.out.println("-------------------------------------------------");
	}
}

public class ExceptionError3 {

	public static void main(String args[]) {

		try {
			System.out.println("매개변수로 받은 두 개의 값");
			int a = Integer.parseInt(args[0]); // 문자열 값을 정수로 변환
			int b = Integer.parseInt(args[1]);
			System.out.println(" a = " + a + " b = " + b);
			System.out.println(" a를 b로 나눈 몫 = " + (a / b));
			System.out.println("나눗셈이 원할히 수행되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			new UserException(e); // 개발자가 만든 예외처리 클래스 사용
		} finally {
			System.out.println("==================================");
			System.out.println("예외 처리를 끝내고 finally 블럭을 수행합니다");
		}
		System.out.println("나머지 루틴을 정상처리합니다.");
	}
}
