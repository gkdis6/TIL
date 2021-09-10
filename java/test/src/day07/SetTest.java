package day07;

import java.util.*;

public class SetTest {
	public static void main(String[] args) {
		HashSet list = new HashSet();

		list.add("lee");// 0
		list.clear();// 모두 제거
		list.add("cho");// 0
		list.add("kim");// 1
		list.add("chung");// 2
		list.add("min");// 3
		list.add("chung");// 2과 동일

		System.out.println("set 사이즈:" + list.size());// size()
		System.out.println(list.contains("chung"));

		list.remove("kim");// 1제거

		System.out.println("kim 제거후 set 사이즈:" + list.size());
		System.out.println(list);
		System.out.println("Iterator객체 이용해서 set출력");
		print(list.iterator());

		System.out.println("배열을 이용해서 set출력");
		print(list.toArray());
	}

	public static void print(Iterator iter) {
		while (iter.hasNext()) {
			String str = (String) iter.next();
			System.out.println(str);
		}
	}//

	public static void print(Object[] obj) {
		int count = obj.length;
		for (int i = 0; i < count; i++) {
			System.out.println(obj[i]);
		}
	}//
}