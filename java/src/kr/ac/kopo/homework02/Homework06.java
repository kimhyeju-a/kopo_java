package kr.ac.kopo.homework02;

import java.util.Scanner;
//6. 단을 입력받아 구구단을 출력하세요

public class Homework06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("2 - 9 단을 입력 : ");
		int a = Integer.parseInt(sc.nextLine());
		sc.close();
		
		System.out.println("\n*** "+ a +" 단***");
		//입력받은 a와 i(1~9)를 곱함 
		for(int i = 1 ; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n",a , i, a*i);
		}
	}
}
