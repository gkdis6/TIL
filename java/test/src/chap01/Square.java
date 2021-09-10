package chap01;

import java.util.Scanner;

public class Square{

    public static void main(String args[]){
		Scanner in = new Scanner(System.in);
	
		System.out.println("사격형을 출력합니다.");
		System.out.print("단 수 : ");
		int n = in.nextInt();
	
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				//System.out.printf("%2s", "*");
				System.out.print("* ");
			}
			System.out.println();
		}
        
    }
}