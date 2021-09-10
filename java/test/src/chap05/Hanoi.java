package chap05;

import java.util.Scanner;

public class Hanoi {

	static void move(int no, int x, int y) {
		if(no > 1)
			move(no - 1, x, 6-x-y);
		
		System.out.print("원반[" + no + "]을 ");
		switch (x) {
		case 1: System.out.print("A기둥에서 "); break;
		case 2: System.out.print("B기둥에서 "); break;
		case 3: System.out.print("C기둥에서 "); break;
		}
		switch (y) {
		case 1: System.out.print("A기둥으로 옮김\n"); break;
		case 2: System.out.print("B기둥으로 옮김\n"); break;
		case 3: System.out.print("C기둥으로 옮김\n"); break;
		}
		
		if(no>1)
			move(no-1, 6-x-y, y);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("하노이의 탑");
		System.out.print("원반의 개수 : ");
		int n = in.nextInt();
		
		move(n, 1, 3);
	}

}
