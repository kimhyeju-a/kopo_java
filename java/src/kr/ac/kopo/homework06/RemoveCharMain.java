package kr.ac.kopo.homework06;

import java.util.Scanner;

public class RemoveCharMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력스트링 : String oriStr = ");
		String oriStr = sc.nextLine();
		
		RemoveChar.print('l', RemoveChar.removeChar(oriStr, 'l'));
		RemoveChar.print('o', RemoveChar.removeChar(oriStr, 'o'));
	}
}
