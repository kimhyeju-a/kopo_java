package kr.ac.kopo.homework01;

import java.util.Scanner;
//4. 화면에서 하나의 정수를 입력 받고 정수를 나눌 수를 입력 받은 다음 몫과 나머지를 화면 에 출력하시오
public class Homework4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("나눌 수를 입력하세요 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		//몫 연산자 : / , 나머지 연산자 : %
		System.out.println("몫 : " + num1/num2);
		System.out.println("나머지 : " + num1%num2);
	}
}
