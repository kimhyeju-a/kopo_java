package kr.ac.kopo.homework10;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarAPI {

	Scanner sc = new Scanner(System.in);

	public void calendarStart() {
		while (true) {
			System.out.print("선택하세요 (1. 특정년도   2. 특정월   3. 종료) : ");
			int ch = sc.nextInt();
			if(ch == 3) {
				System.out.println("종료....");
				break;
			}
			switch (ch) {
			case 1:
				yearPrint();
				break;
			case 2:
				monthPrint();
				break;
			default:
				again();
				break;
			}
		}
	}
	
	//각 달에 맞는 날짜를 배열에 저장....
	public void standard(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);

		// 배열을 만들기 위해 마지막날 + 요일수를 더한다.
		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int day = c.get(Calendar.DAY_OF_WEEK);
		
		//달의 요일수(?) 를 정할 배열의 크기를 정한다. 
		int Idx = lastDay + day;
		int[] calendarDay = new int[Idx];
		
		// 달력에 1부터 넣음
		int num = 1;
		// 공백을 넣기 위해 요일까지는 0을 넣어준다.
		for (int i = 0; i < day; i++) {
			calendarDay[i] = 0;
		}
		// 달력에 1부터 넣어준다.
		for (int i = day; i < calendarDay.length; i++) {
			calendarDay[i] = num++;
		}

		print(calendarDay);
	}

	public void print(int[] calendarDay) {
		System.out.println("일   월   화   수   목   금   토 ");
		for(int i = 0; i < calendarDay.length; i++) {
			//교수님 이부분이 제폰트문제인지,, 아니면 제가 잘못쓴거인지 
			/*
			일   월   화   수   목   금   토 
			                  1  2  
			3  4  5  6  7  8  9  
			10 11 12 13 14 15 16 
			
			줄정렬이 되지 않습니다 ㅠㅠ 무슨폰트를 써야할까요 ..?
			 */
			if(calendarDay[i]==0) {
				System.out.printf("%-3s", "");
			}else {
				System.out.printf("%-3d",calendarDay[i]);
			}
			if(i > 0 && i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("");
	}

	public void yearPrint() {
		System.out.print("년도를 입력하세요 : ");
		int year = sc.nextInt();
		for (int i = 0; i < 12; i++) {
			System.out.println("<< " + year + "년 " + (i+1) + "월 >> ");
			standard(year, i);
		}
		System.out.println("");
	}

	public void monthPrint() {
		System.out.print("년도를 입력하세요 : ");
		int year = sc.nextInt();
		System.out.print("월을 입력하세요 : ");
		int month = sc.nextInt();
		standard(year, month);
	}
	
	public void again() {
		System.out.println("잘못입력했습니다. 1,2,3 중에 고르세요");
		calendarStart();
	}
}