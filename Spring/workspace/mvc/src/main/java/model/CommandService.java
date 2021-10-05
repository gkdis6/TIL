package model;

import java.util.Date;

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
}
