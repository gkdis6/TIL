package chap04;

import java.util.Scanner;

public class IntStackTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		IntStack s = new IntStack(64);
		
		while(true) {
			System.out.println("현재 데이터 수 : " + s.size() + "/" + s.capacity());
			System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)인덱스 (6)클리어 (0)종료 : ");
			
			int menu = in.nextInt();
			if(menu == 0) break;
			
			int x;
			switch (menu) {
			case 1: 
				if(s.isFull() == true) {
					System.out.println("스택이 가득 찼습니다.\n");
				}else {
					System.out.print("데이터 : ");
					x = in.nextInt();
					s.push(x);
					System.out.println();
				}
				break;
			
			case 2:
				if(s.isEmpty() == true) {
					System.out.println("스택이 비어 있습니다.\n");
				}else {
					x = s.pop();
					System.out.println("팝한 데이터는 "+ x + "입니다.\n");
				}
				break;
				
			case 3:
				if(s.isEmpty() == true) {
					System.out.println("스택이 비어 있습니다.\n");
				}else {
					x = s.peek();
					System.out.println("피크한 데이터는 "+x+"입니다.\n");
				}
				break;
				
			case 4:
				if(s.isEmpty() == true) {
					System.out.println("스택이 비어 있습니다.\n");
				}else {
					s.dump();
					System.out.println();
				}
				break;
				
			case 5:
				if(s.isEmpty() == true) {
					System.out.println("스택이 비어 있습니다.\n");
					break;
				}
				System.out.print("찾을 데이터 : ");
				x = in.nextInt();
				int idx = s.indexOf(x);
				if(idx < 0) {
					System.out.println("찾는 값이 없습니다.\n");
				}else {
					System.out.println("찾는 값은 x["+idx+"]에 있습니다.\n");
				}
				break;
			
			case 6:
				if(s.isEmpty() == true) {
					System.out.println("이미 스택이 비어 있습니다.\n");
				}else {
					s.clear();
					System.out.println("스택을 비웠습니다.\n");
				}
				break;
			}
		}
	}
}
