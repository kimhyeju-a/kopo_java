package kr.ac.kopo.day11;

import java.util.Calendar;
import java.util.Date;

public class CalendarMain {

	public static void main(String[] args) {
		// 오늘은 2020년 04월 27일(월요일)입니다.
		Calendar c = Calendar.getInstance();
		System.out.println("c : " + c.toString());
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		date = c.get(Calendar.DAY_OF_MONTH);
		int day = c.get(Calendar.DAY_OF_WEEK); // 1(일) ~ 7(토)
		String[] dayArr = {"", "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
		
		System.out.println("오늘은 " + year + "년 " + month + "월 " + date + "일 (" + dayArr[day] + ") 입니다." );
//		System.out.println("Day : " + day);
		
		//set은 오버로딩을 지원한다.
		// 2023년 10월 9일은 무슨요일?
		// 월은 0~11 이므로 -1 을해준다 10을 할경우 11월달이 나옴
		c.set(2023, 10-1, 9);
		
		day = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("2023년 10월 9일은 " + dayArr[day] +"입니다.");
		//Date형으로 바꿔줌
		Date d = c.getTime();
		System.out.println(d);
		
		System.out.println(c);
		d = new Date();
		c.setTime(d);
		
		System.out.println(c);
		
		//이번달의 마지막날수 
		c.set(Calendar.MONTH, 2-1);
		month = c.get(Calendar.MONTH);
		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(month + "월의 마지막날은 " + lastDay + " 일입니다.");
		
		System.out.println("마지막월은 : " + c.getActualMaximum(Calendar.MONTH) + 1);
	}
}
