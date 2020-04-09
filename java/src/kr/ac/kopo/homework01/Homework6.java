package kr.ac.kopo.homework01;

import java.util.Scanner;

// 6. 알파벳이 모두 몇 자 인지 화면에 출력하시오 
public class Homework6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("알파벳을 입력하세요. : ");
		String str = sc.nextLine();
		int cnt = 0;
		
		//알파벳이 아닌 것 골라내는 코드
		for (int i = 0; i<str.length(); i++) {
			char check = str.charAt(i);
			//아스키코드로 65~90, 97~122 만 알파벳
			if((int)check >= 65 && (int)check <=90) {
				cnt++;
			}else if ((int)check >= 65 && (int)check <=90) {
				cnt++;
			}
		}
		System.out.println("개수 : " + cnt);
	}
}
