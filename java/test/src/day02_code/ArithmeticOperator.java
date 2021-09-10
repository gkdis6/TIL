package day02_code;

public class ArithmeticOperator {

	public static void main(String[] args) {
		final int TIME = 500;
		int second, minute, hour;
		
		second = TIME%60;
		minute = (TIME/60)%60;
		hour = (TIME/60)/60;
		
		System.out.println(TIME + "초는 ");
		System.out.println(hour + "시간 ");
		System.out.println(minute + "분 ");
		System.out.println(second + "초입니다.");
	}

}
