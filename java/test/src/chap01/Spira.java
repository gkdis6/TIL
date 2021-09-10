package chap01;

public class Spira {
	public static void main(String[] args) {
		spira(3);
		npira(4);
	}
	
	public static void spira(int n) {
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n-i;j++) {
				System.out.print("  ");
			}
			for(int j = 1; j<2*i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	public static void npira(int n) {
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n-i;j++) {
				System.out.print("  ");
			}
			for(int j = 1; j<2*i; j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
