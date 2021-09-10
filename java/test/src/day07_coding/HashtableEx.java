package day07_coding;

import java.util.*;

public class HashtableEx {
	public static void main(String[] args) {
		Hashtable h = new Hashtable(); //
		h.put("21", "홍길동");
		h.put("54", "황기태");
		h.put("76", "이소룡");
		h.put("123", "해리슨포드");
		System.out.println("Hashtable의 키 개수 : " + h.size()); // 키의 개수

		Enumeration e = h.keys(); // Hashtable의 모든 키들을 얻어옴
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement(); // 키
			String value = (String) h.get(key); // 키에 매핑된 값
			System.out.println(key + ":" + value);
		}
	}
}