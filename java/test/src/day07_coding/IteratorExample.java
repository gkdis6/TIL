package day07_coding;

import java.util.*;

public class IteratorExample {
	public static void main(String[] args) {
		ArrayList a = new ArrayList(); // 빈 리스트 생성
		a.add("Hello");
		a.add(3); // 자동 박싱, JDK 1.5 이후에서만 실행됨
		a.add(3.14); // 자동 박싱
		a.add(2, 3.4); // 자동 박싱, 인덱스 2에 객체 삽입
		Iterator i = a.iterator(); // Iterator 객체 반환
		while (i.hasNext()) { // Iterator 객체에 요소가 있을 때 까지 반복
			Object obj = i.next(); // 다음 요소 반환
			if (obj instanceof String) { // String 객체의 경우
				String str = (String) obj;
				System.out.println(str);
			} else if (obj instanceof Integer) { // Integer 객체의 경우
				int n = (Integer) obj; // 자동 언박싱, JDK 1.5 이후에서만 실행됨
				System.out.println(n);
			} else if (obj instanceof Double) { // Double 객체의 경우
				double d = (Double) obj; // 자동 언박싱, JDK 1.5 이후에서만 실행됨
				System.out.println(d);
			}
		}
	}
}