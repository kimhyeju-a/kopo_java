package kr.ac.kopo.day11;

import java.util.Date;

//import kr.ac.kopo.day08.Icecream;
/*
	deprecated의 방법이므로 추천하지 않는다. 따라서 calender클래스를 추천한다.
 */
public class DateMain {

	public static void main(String[] args) {
		
//		Icecream ice = new Icecream("aaa" , 1000);
//		System.out.println("ice : " + ice);
//		System.out.println("ice : " + ice.toString());
		
		// 오늘은 2020년 04월 27일입니다.
		Date d = new Date();
		
		System.out.println("d : " + d);
		//date에서의 년도는 1900년부터 시작 가운데 선이 있음 => 추천하지않음 deprecated
		int year = d.getYear() + 1900;
		//0~11 로 나옴
		int month = d.getMonth() + 1;
		int date = d.getDate();
		System.out.println("오늘은 " + year + "년 " + month + "월 " + date +"일입니다.");
	}
}
