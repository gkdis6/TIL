package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;

public class CalendarExam {

	public static String hundredDaysAfter() {
		Calendar cal = Calendar.getInstance();
        
		cal.add(Calendar.DATE, 100);
		
        int yyyy = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int date = cal.get(Calendar.DATE);
        
        String str = new StringBuffer().append(yyyy).append("년").append(month).append("월").append(date).append("일").toString();
        
        return str;
	}
	
	public static void main(String[] args) {
		
		System.out.println(hundredDaysAfter());
		
		LocalDateTime timePoint = LocalDateTime.now();
		
		LocalDate ld1 = LocalDate.of(2012, Month.DECEMBER, 12);
		LocalTime lt1 = LocalTime.of(17, 18);
		LocalTime lt2 = LocalTime.parse("10:15:30");
		
		LocalDate theDate = timePoint.toLocalDate();
		Month month = timePoint.getMonth();
		int day = timePoint.getDayOfMonth();
		int hour = timePoint.getHour();
		int minute = timePoint.getMinute();
		int second = timePoint.getSecond();
		
		System.out.println(month.getValue() + "/" + day + " " + hour + ":" + minute + ":" + second);
	}
	
}
