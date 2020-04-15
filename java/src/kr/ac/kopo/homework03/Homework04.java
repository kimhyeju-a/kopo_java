package kr.ac.kopo.homework03;

import java.util.Scanner;
/*
	4. 다음의 결과를 보이는 프로그램을 작성하시오.
		int[] nums = new int[30];
		1 – 100사이의 정수를 입력하시오 : 64
		64의 약수의 개수 : 7개
		< 64의 7개 약수 출력 >
		1 2 4 8 16 32 64
		1 – 100사이의 정수를 입력하시오 : 79
		79의 약수의 개수 : 2개
		< 79의 2개 약수 출력 >
		1 79
		5. 2 ~ 100사이의 소수를 출력하는 코드를 작성
		< 2 ~ 100사이의 소수 출력 >
		2 3 5 7 11 13 17 … 97
 */

public class Homework04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[30];
		int cnt = 0;
		System.out.print("1 - 100사이의 정수를 입력하시오 : ");
		int num = sc.nextInt();
		sc.close();
		//약수를 구한다. cnt로 약수의 개수를 구한다.
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				nums[cnt++] = i;
			}
		}
		System.out.printf("%d의 약수의 개수 : %d개 \n", num, cnt);
		System.out.printf("< %d의 %d개 약수 출력 >\n", num, cnt);
		for(int i = 0; i < cnt ; i++ ) {
			System.out.print(nums[i] + " ");
		}
	}
}
