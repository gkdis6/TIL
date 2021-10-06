package model;

import java.util.*;

public class CommandService {

	public StringBuffer getHello() {
		StringBuffer sb = new StringBuffer();
		sb.append("<li> 안녕하세요..MVC 입니다.<br>"); 
        sb.append("<li> Template Page<br>"); 
        sb.append("<li> URI Command Pattern<br>"); 
        sb.append("<li> Properties 파일을 이용한 처리입니다.<br>"); 
		
		return sb;
	}
	
	public String getDate() {
		Date dt = new Date();
		
		return dt.toLocaleString();
	}

	public StringBuffer getMyinfo() {
		StringBuffer sb = new StringBuffer();
		sb.append("<li> 이름 : 홍길동 <br>"); 
        sb.append("<li> 나이 : 30 "); 
        sb.append("<li> 보유기술 : Java, Jsp, Spring <br>"); 
        sb.append("<li> 성격 : 매우 호의적이다. <br>"); 
		
        return sb;
	}
	
	public List<Map> getTeam(){
		List<Map> list = new ArrayList();;
		Map map = new HashMap();
		map.put("no", 1);
		map.put("name", "홍길동");
		map.put("age", 30);
		map.put("skill", "java");
		map.put("person", "착하다");
		list.add(map);
		
		map = new HashMap();
		map.put("no", 2);
		map.put("name", "홍길동2");
		map.put("age", 31);
		map.put("skill", "java");
		map.put("person", "착하다");
		list.add(map);
		
		map = new HashMap();
		map.put("no", 3);
		map.put("name", "홍길동3");
		map.put("age", 32);
		map.put("skill", "jsp");
		map.put("person", "착하다");
		list.add(map);
		
		map = new HashMap();
		map.put("no", 4);
		map.put("name", "홍길동4");
		map.put("age", 33);
		map.put("skill", "java, kotlin");
		map.put("person", "착하다");
		list.add(map);
		
		map = new HashMap();
		map.put("no", 5);
		map.put("name", "홍길동5");
		map.put("age", 34);
		map.put("skill", "kotlin");
		map.put("person", "착하다");
		list.add(map);
		
		return list;
	}
}
