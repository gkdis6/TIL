package day07;

import java.util.HashMap;
import java.util.*;


public class MapTest {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(0, "lee");
		map.clear();
		map.put(1, "cho");
		map.put(2, "kim");
		map.put(3, "chung");
		map.put(4, "min");
		map.put(3, "jung");

		System.out.println(map);

		System.out.println(map.size());
		System.out.println(map.containsKey(3));
		System.out.println(map.containsValue("chung"));

		map.remove(2);
		System.out.println(map);
		System.out.println(map.size());

		print(map);
	}

	private static void print(HashMap<Integer, String> map) {
		Set set = map.keySet();
		System.out.println(set);
		
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			Integer key = (Integer)iter.next();
			System.out.println(key + " = " + map.get(key));
			
		}
		
	}

}
