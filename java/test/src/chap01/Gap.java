package chap01;

import java.util.Scanner;

public class Gap{

    public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int b;	
		
		System.out.print("a의 값 : "); int a = in.nextInt();
		do{
			System.out.print("b의 값 : ");
			b = in.nextInt();
			if(b<=a){
				System.out.println("a보다 큰 값을 입력해주세요.");
			}
		}while(b<=a);
		System.out.println("a 와 b값의 차이는 "+(b-a)+"입니다.");
    }
}
