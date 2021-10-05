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
}
