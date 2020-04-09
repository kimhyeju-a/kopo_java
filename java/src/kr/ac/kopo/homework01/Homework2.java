package kr.ac.kopo.homework01;

import java.util.Scanner;
// 2. 3661초가 몇 시간 몇 분 몇 초인지 환산해서 출력하시오 
public class Homework2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("초를 입력하세요 : ");
		int sec = Integer.parseInt(sc.nextLine());
		System.out.print(sec + "초 : ");
		int min = sec / 60; //초를 60분으로 나누게 되면 분이 나옴
		int hour = min / 60; // 분을 60분으로 나누게 되면 시간이 나옴
		sec = sec % 60; //초는 초를 60으로 나눈 나머지
		min = min % 60; // 분은 분을 60으로 나눈 나머지
		
		//초부터 차례대로 검사
		if(sec == 0) {
			if(min == 0) {
				System.out.printf("%d시간 %d분 %d초 -> %d시간 ",hour ,min , sec, hour);
			}
			else {
				System.out.printf("%d시간 %d분 %d초 -> %d시간 %분",hour ,min , sec, hour, min);
			}
		}else if(min == 0) {
			System.out.printf("%d시간 %d분 %d초 -> %d시간 %d초",hour ,min , sec, hour, sec);
		}else {
			System.out.printf("%d시간 %d분 %d초 ",hour ,min , sec);
		}
	}
}
