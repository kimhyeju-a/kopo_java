package kr.ac.kopo.util;

import java.util.Scanner;
//화면과 관련된 기능을 하는 클래스는 View 나 Util을 쓴다.
//여기서는 View는 화면입력, Util은 화면 출력을 담당한다.
public class CalendarView {

	private Scanner sc;
	private CalendarUtil util;
	
	public CalendarView() {
		sc = new Scanner(System.in);
		util = new CalendarUtil();
	}

	private int scanInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();

		return num;
	}

	public void execute() {
//		loop : while (true) {
		while(true) {
			int no = scanInt("항목을 선택하세요(1.특정년도 2.특정월 3.종료 ): ");
			
			switch (no) {
			case 1:
				int year = scanInt("년도를 입력하세요. : ");
				util.showByYear(year);
				break;
			case 2:
				year = scanInt("년도를 입력하세요. : ");
				int month = scanInt("월을 입력하세요 : ");
				util.showByMonth(year, month);
				
				break;
			case 3:
				System.out.println("3번 선택");
				System.exit(0); // 0은 정상적인 종료 , 프로그램은 종료하는 메소드
//				break loop;
			}
		}
	}
}
