package day03_test;

public class Ex03 {

	public static void main(String[] args) {
		int[] arr = {-43, 45, 67, 33, -66};
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]<0) arr[i] = -arr[i];
			System.out.print(arr[i]+" ");
		}

	}

}
