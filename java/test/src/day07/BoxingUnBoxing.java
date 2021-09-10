package day07;

import java.util.*;

public class BoxingUnBoxing {
	public static void main(String[] args) {
		Vector<Short> v = new Vector<Short>(5, 5); // Generics
		v.add((short) 1324);// boxing //Java5
		v.add((short) 532);
		v.add((short) 452);
		v.add((short) 843);
		v.add((short) 331);
		prints(v);
	}

	public static void prints(Vector<Short> vi) {
		int num = vi.size();
		short sum = 0;
		for (int j = 0; j < num; j++) {
			sum += vi.get(j);
		} // for
		System.out.println("합   : " + sum);
	}// prints
}
