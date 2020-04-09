package kr.ac.kopo.day02;

import java.util.Scanner;

public class SwitchMain02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("좋아하는 계절을 입력하세요 : ");
		String season = sc.nextLine();
		
		switch(season) {
		case "봄" :
		case "spring" :
		case "SPRING" :
			System.out.println(season + "은 3월 ~ 5월까지입니다.");
			break;
		case "여름" : case "summer" : case "SUMMER" :
			System.out.println(season + "은 6월 ~ 8월까지입니다.");
			break;
		case "가울" :
			System.out.println(season + "은 9월 ~ 11월까지입니다.");
			break;
		case "겨울" :
			System.out.println(season + "은 12~ 2월까지 입니다.");
		}
		
		//문자열 같은 경우 비교할 때 == 으로 비교 안되고, .equals 를 사용해야함
		/*
		if(season.equals("봄")) {
			System.out.println(season + "은 3~5월 까지입니다.");
		}
		*/
	}
}
