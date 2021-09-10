package chap01;

import java.util.Scanner;

public class X10{

    public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n;
		System.out.println("양의 정수를 입력해주세요.");
		do{
			System.out.print("정수 n : ");
			n = in.nextInt();
		}while(n <= 0);
		
		int b = 1;
		int a = 1;
		while(n/a >= 10){
			a=a*10;
			b++;
		}

		System.out.println("n은 "+b+"자리입니다.");
		
    }
}
