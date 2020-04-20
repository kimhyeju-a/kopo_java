package kr.ac.kopo.homework06;

import java.util.Scanner;

public class CheckChar {
	Scanner sc = new Scanner(System.in);
	public static int checkChar(String strData, char ch) {
		int cnt = 0;
		int searchIdx = -1;
		while((searchIdx = strData.indexOf(ch, searchIdx +1)) != -1) {
			cnt++;
		}
		return cnt;
	}
	public static void print(char ch, int cnt) {
		System.out.println("ch = '" + ch + "'인 경우 => " + cnt +"리턴");
	}
}
