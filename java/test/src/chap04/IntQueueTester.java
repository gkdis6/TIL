package chap04;

import java.util.Scanner;

public class IntQueueTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		IntQueue s = new IntQueue(5);
		
		while (true) {
			System.out.println("현재 데이터 수 : "+s.size() +"/" + s.capacity());
			System.out.print("(1)인큐 (2)디큐 (3)피크 (4)덤프 (5)서치 (0)종료 : ");
			
			int menu = in.nextInt();
			if(menu == 0) break;
			
			int x;
			switch(menu) {
			case 1:
				System.out.print("데이터 : ");
				x = in.nextInt();
				try {
					s.enque(x);
				}catch(IntQueue.OverflowIntQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;
				
			case 2:
				try {
					x = s.deque();
					System.out.println("디큐한 데이터는 "+x+"입니다.");
				} catch (IntQueue.EmptyIntQueeueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
			
			case 3:
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x +"입니다.");
				}catch (IntQueue.EmptyIntQueeueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
				
			case 4:
				s.dump();
				break;
				
			case 5:
				try {
					System.out.print("찾을 데이터 : ");
					x = in.nextInt();
					x = s.search(x);
					if(x == 0)
						System.out.println("값이 존재하지 않습니다.");
					else
						System.out.println(x+"번째에 있습니다.");
				}catch (IntQueue.EmptyIntQueeueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
			}
		}
	}
}
