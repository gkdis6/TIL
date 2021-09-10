package day07;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class TestHashTable {

	public static void main(String[] args) {
		Hashtable ht = new Hashtable<>();
		ht.put("AREA01", "대한민국");
		ht.put("AREA02", "러시아");
		ht.put("AREA03", "중국");
		ht.put("AREA04", "일본");
		
		String area = (String) ht.get("AREA01");
		
		if(area != null) {
			System.out.println(area);
		}else {
			System.out.println("검색지역이 없습니다.");
		}
		
		Iterator iter = ht.keySet().iterator();
		while(iter.hasNext()) {
			String key = (String) iter.next();
			System.out.println(key + " = " + ht.get(key));
		}
		
		Enumeration e = ht.keys();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			System.out.println(key + " = " + ht.get(key));
			
		}
	}

}
