package kr.ac.kopo.homework05;

import java.util.Scanner;
// 8. 사칙연산을 수행하는 Calculator 클래스 작성 
public class CalculatorMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("정수 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		//인스턴스 객체 생성시, 생성자를 이용해 사칙연산 수행
		Calculator cal = new Calculator(num1, num2);
		
		//소수 체크
		System.out.println(num1 + " 소수체크 : " + cal.sosu(num1));
		System.out.println(num2 + " 소수체크 : " + cal.sosu(num2));
		
		sc.close();
	}
}
