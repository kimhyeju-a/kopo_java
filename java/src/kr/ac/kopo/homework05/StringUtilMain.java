package kr.ac.kopo.homework05;

import java.util.Scanner;

public class StringUtilMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringUtil su = new StringUtil();
		
		System.out.print("1. 하나의 문자를 입력하세요.(대문자 true반환) : ");
		//여러개의 문자를 입력해도 무조건 0번째 인덱스만 검사하도록
		su.oneTwo(su.isUpperChar(sc.nextLine().charAt(0)));
		
		System.out.print("2. 하나의 문자를 입력하세요.(소문자 true반환) : ");
		//여러개의 문자를 입력해도 무조건 0번째 인덱스만 검사하도록
		su.oneTwo(su.isLowerChar(sc.nextLine().charAt(0)));
		
		System.out.print("3. 두개의 숫자를 입력하세요 (ex.12 34) : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		sc.nextLine();
		System.out.println(num1 + "과 " + num2 +"중 더 큰 수는 : " + su.max(num1, num2) + " 입니다.");

		System.out.print("4. 두개의 숫자를 입력하세요 (ex.12 34) : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		sc.nextLine();
		System.out.println(num1 + "과 " + num2 +"중 더 작은수는 수는 : " + su.min(num1, num2) + " 입니다.");
		
		System.out.print("5. reverseStirng 에 넣을 문자열을 입력하세요 : ");
		System.out.println("변환문자열: " +su.reverseString(sc.nextLine()));
		
		System.out.print("6. toUpperStirng 에 넣을 문자열을 입력하세요 : ");
		System.out.println("변환문자열: " +su.toUpperString(sc.nextLine()));

		System.out.print("7. toLowerStirng 에 넣을 문자열을 입력하세요 : ");
		System.out.println("변환문자열: " +su.toLowerString(sc.nextLine()));
		
		sc.close();
		
	}
}
