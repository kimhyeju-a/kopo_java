package kr.ac.kopo.homework06;

import java.util.Scanner;

public class CheckCharMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력스트링 : String strData = ");
		String strData = sc.nextLine();
		int cnt;
		
		cnt = CheckChar.checkChar(strData, 'o');
		CheckChar.print('o',cnt);
		cnt = CheckChar.checkChar(strData, 'w');
		CheckChar.print('W',cnt);
	}
}
