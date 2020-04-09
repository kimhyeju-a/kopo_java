package kr.ac.kopo.homework01;

import java.util.Scanner;

//7. 화면에서 알파벳을 입력 받아 대문자는 소문자로 소문자는 대문자로 출력하는 프로그램을 작성하시오 
public class Homework7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		System.out.print("입력 알파벳 : ");
		String str = sc.nextLine();
		
		for (int i = 0; i<str.length(); i++) {
			char check = str.charAt(i);
			//한글자를 askii코드로 변환시킴
			int askii = (int)check;
			
			//아스키코드로 65~90, 97~122 만 알파벳
			if(askii >= 65 && askii <=90) {
				//65(a)를 기준으로 32를 더하면 97(A)이 됨
				System.out.print((char)(askii+32));
			}else if ((int)check >= 97 && (int)check <=122) {
				System.out.print((char)(askii-32));
			}else {
				//알파벳이 아닌 경우 출력
				System.out.print(check);
			}
		}
	}
}