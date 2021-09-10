package day07_coding;

import java.util.*;

public class VectorExample {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>(3); // Integer를 요소로하는 용량 3의 벡터 생성
		System.out.println("벡터의 초기 크기는 " + v.capacity());
		v.add(new Integer(1));
		v.add(new Integer(22));
		v.add(new Integer(51));
		v.add(new Integer(10));
		System.out.println("벡터의 크기는 " + v.capacity());
		Collections.sort(v); // 요소 순서대로 정렬
		for (int i = 0; i < v.size(); i++) { // 벡터에 있는 모든 요소에 대해 반복
			Integer n = v.elementAt(i); // 요소 객체 알아내기
			System.out.println(n.toString());
		}
	}
}