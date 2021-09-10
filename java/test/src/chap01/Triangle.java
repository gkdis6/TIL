package chap01;

public class Triangle{
	public static void TriangleLB(int n){
		System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");
		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=i; j++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void TriangleLU(int n){
		System.out.println("왼쪽 위가 직각인 이등변 삼각형을 출력합니다.");
		for(int i = n; i>=1; i--){
			for(int j = 1; j<=i; j++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void TriangleRU(int n){
		System.out.println("오른쪽 위가 직각인 이등변 삼각형을 출력합니다.");
		for(int i = n; i>=1; i--){
			for(int j = n-i; j>=1; j--){
				System.out.print("  ");
			}
		
			for(int j = i; j>=1; j--){
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void TriangleRB(int n){
		System.out.println("오른쪽 아래가 직각인 이등변 삼각형을 출력합니다.");
		for(int i = 1; i<=n; i++){
			for(int j = n-i; j>=1; j--) {
				System.out.print("  ");
			}
			for(int j = 1; j<=i; j++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	
}



