package kr.ac.kopo.day02;

import java.util.Scanner;

/*
	n개의 문장을 구분하고 싶을 때에는 n-1개의 if문을 쓰면 된다.
 */
public class IfMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("기상한다.");

		System.out.print("집에서 출발한 시간을 입력 (7시 10분 710입력): ");
		int startTime = sc.nextInt();
		sc.nextLine();
		
		if( startTime < 800 ) {
			System.out.println("걸어서");
		} else {
			if ( startTime < 815 ) {
				System.out.println("버스타고");
			}else {
				System.out.println("택시타고");
			}
		}
		
		/*
		if(startTime < 800) {
			System.out.println("걸어서");
		}else if(startTime < 815) {
			System.out.println("버스타고");
		}else {
			System.out.println("택시타고");
		}
		*/
		
//		System.out.println(startTime >= 800 ? "버스타고" : "걸어서");
		
		/*
		if(startTime < 800) {
			System.out.println("걸어서");
		} else {
			System.out.println("버스타고");
		}
		System.out.println("학교간다.");
		*/
		
		/*
		System.out.println("기상한다.");
		
		System.out.print("일어난 시간을 입력하세요 (7시 10분 710입력): ");
		int 기상시간 = sc.nextInt();
		sc.nextLine();
				
		if(기상시간 < 700) {
			System.out.println("밥먹고");
		}
		System.out.println("학교간다.");
		*/
	}
}
