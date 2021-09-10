package day03_test;

public class Ex01 {

	public static void main(String[] args) {
		int[] arr = {43, 54, 34, 23, 15};
		double sum = 0;
		//평균을 따로 정의하고 싶지 않아서 double로 선언
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println((int) sum);
		//깔끔하게 보이기 위해 int로 강제 형변환
		System.out.println(sum/arr.length);

	}

}
