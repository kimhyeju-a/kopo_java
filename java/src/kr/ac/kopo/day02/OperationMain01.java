package kr.ac.kopo.day02;

import java.util.Scanner;

public class OperationMain01 {
	public static void main(String[] args) {
/*
		Scanner sc = new Scanner(System.in);
		System.out.print("a정수를 입력 : ");
		int a = sc.nextInt();
		sc.nextLine();
		
		System.out.print("b정수를 입력 : ");
		int b = sc.nextInt();
		sc.nextLine();
		
		boolean result = b!=0 && a % b == 0;
		System.out.println("약수 여부 : " + result);
	*/	
		
		/*
		System.out.print("ㅁ 정수를 입력 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		boolean result = num >= 0 && num % 2 == 0;
		System.out.println(num + " 짝수판단 여부 : " + result);
		*/
		int a = 1, b = -1, c = 0;

		boolean bool = ++a > 0 && ++b > 0;
		// a = 2, b = 0, c = 0, bool = False
		System.out.printf("a = %d b = %d c = %d bool = %b\n", a, b, c, bool);

		bool = --a > 0 && --b > 0;
		// a = 0, b = -1, c = 0, bool = False (b는 아예 보지 않음)
		System.out.printf("a = %d b = %d c = %d bool = %b\n", a, b, c, bool);

		bool = --b > 0 && --a > 0;
		// a = 1, b = -2, c = 0, bool = False (a는 아예 보지 않음)
		System.out.printf("a = %d b = %d c = %d bool = %b\n", a, b, c, bool);

	}
}
