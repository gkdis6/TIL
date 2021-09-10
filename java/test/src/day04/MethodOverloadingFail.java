package day04;

public class MethodOverloadingFail {

	public int getSum(int i, int j) {
		return i+j;
	}
	
	public int getSum(int i, int j, int k) {
		return i+j+k;
	}
	
	public double getSum(double i, double j) {
		return i+j;
	}
	
	public static void main(String[] args) {

	}

}
