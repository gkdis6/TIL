package day07;

import java.util.*;

public class ListTest1 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("lee");
		list.clear();
		list.add("cho");
		list.add("kim");
		list.add("chung");
		list.add("min");
		list.add("chung");
		System.out.println("ArrayList 사이즈:" + list.size());// size()
		System.out.println(list.contains("chung"));
		list.remove("kim");
		list.remove(3);
		System.out.println("ArrayList 사이즈:" + list.size());
		System.out.println("min이 있는 위치값:" + list.indexOf("min"));

		System.out.println("Iterator를 이용해서 출력");
		print(list);
		System.out.println("배열를 이용해서 출력");
		print(list.toArray());
		// ArrayList 에서 0에서 1까지의 데이타 추출
		List sublist = list.subList(0, 2);// 0~2-1까지
		System.out.println("추출된 데이타만 출력");
		print(sublist);
		System.out.println("for문을 이용해서 출력");
		printGet(list);
	}

	public static void print(List list) {
		Iterator iter = list.iterator();
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

	public static void printGet(List set) {
		int count = set.size();
		for (int i = 0; i < count; i++) {
			System.out.println(set.get(i));
			// String str=(String)set.get(i)
		}
	}//
}