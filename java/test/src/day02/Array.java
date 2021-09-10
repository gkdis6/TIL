package day02;

public class Array {
	public static void main(String[] args) {
		int[] pay = { 1800, 2200, 2600, 3000, 3400, 3800 };

//        System.out.println(pay[0]); //pay 배열 index 0의 값 
//        System.out.println(pay[1]); 
//        System.out.println(pay[2]); 
//        System.out.println(pay[3]); 
//        System.out.println(pay[4]); 
//        System.out.println(pay[5]); 

		int i = 0;

		// i는 5보다 작거나 같을 경우 실행
		for (i = 0; i <= 5; i++) { // 0,1,2,3,4,5,6
			System.out.println(i + "년차 연봉: " + pay[i]);
		}
		System.out.println(i);
	}
}