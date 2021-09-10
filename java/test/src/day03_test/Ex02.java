package day03_test;

public class Ex02 {

	public static void main(String[] args) {
		double[] arr = {43, 67, 63, 14, 68};
		//실수라고 적혀있어 doubleArray로 선언
		double max = arr[0];
		double min = arr[0];
		//0이나 특정 숫자로 정의할 경우 문제가 생길 수 있어 0번으로 정의
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]>max) max = arr[i];
			if(arr[i]<min) min = arr[i];
		}
		System.out.println("최댓값 : "+max);
		System.out.println("최솟값 : "+min);
		
	}

}
