package day07;

import java.util.*;

public class BoxingUnBoxingMain {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>(5, 5); // Generics
		v.add(1);// boxing //Java5
		v.add(5);
		v.add(4);
		v.add(8);
		v.add(3);
		prints(v);
	}

	public static void prints(Vector<Integer> vi) {
		int num = vi.size();
		int sum = 0;
		for (int j = 0; j < num; j++) {
			sum += vi.get(j);
		} // for
		System.out.println("합   : " + sum);
	}// prints
}
