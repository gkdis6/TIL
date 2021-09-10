package day07_coding;

import java.util.*;

public class HashTableExample {
	public static void main(String[] args) {
		Hashtable members = new Hashtable(); //
		Scanner sin = new Scanner(System.in);
		System.out.println("공백으로 분리된 이름과 전화번호 5개를 입력하십시오.");
		for (int i = 0; i < 5; i++) {
			System.out.print("이름, 전화번호 : ");
			String name = sin.next(); // 이름 입력
			String tel = sin.next(); // 전화번호 입력
			members.put(name, tel); // 이름이 키, 전화번호를 값으로 Hashtable에 저장
		}
		System.out.println("전화번호를 검색할 이름을 입력하십시오.");
		String key = sin.next(); // 키인 이름 입력
		String val = (String) members.get(key); // 키로 매핑된 전화번호 검색
		if (val != null)
			System.out.println(key + "의 전화번호는 " + val + "입니다.");
		else
			System.out.println("입력하신 이름을 찾을 수 없습니다.");

	}
}