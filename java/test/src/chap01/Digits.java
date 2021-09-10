package chap01;

import java.util.Scanner;

public class Digits{

    public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n;
		
		System.out.println("2자리 정수를 입력하세요.");
		do{
			System.out.print("n의 값 : ");
			n = in.nextInt();
		}while(n<10 || n>99);
      System.out.println("변수 n의 값이 "+n+"이(가) 되었습니다.");
    }
}