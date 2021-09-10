package day07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generic2 {

	public static void main(String[] args) {
		// 선언되는 list는 Integer 클래스 타입만 저장할 수 있습니다.
		ArrayList<Integer> list = new ArrayList<Integer>(10);
		list.add(10);

		// ERROR 강제 발생 부분, Integer 타입만 가능,
		// Design Time에서 발견됩니다.
		//list.add("List Test");

		Iterator i = list.iterator();
		Integer su = (Integer) i.next();
		System.out.println("su=" + su);

		su = (Integer) i.next();
		System.out.println("su=" + su);
	}
}