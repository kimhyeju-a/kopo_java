package kr.ac.kopo.homework03;

import java.util.Scanner;
/*
	2. 5개의 짝수를 입력받아 출력하는 코드를 작성
	 1's 정수 : 12
	 2's 정수 : 5
	 2's 정수 : 20
	 3's 정수 : 10
	 4's 정수 : 26
	 5's 정수 : 5
	 5's 정수 : 11
	 5's 정수 : 4
	
	 < 5개의 정수 출력 >
	 12 20 10 26 4

 */
public class Homework02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] evenArr = new int[5];
		
		//5개의 짝수를 입력받음
		for(int i = 0; i < 5; i++) {
			System.out.print(i+1 +"'s 정수 : ");
			int num = sc.nextInt();
			//입력받은 정수가 짝수라면 evenArr에 넣고, 아니면 i--를 수행하여 다시 반복문을 수행하도록 함
			if(num % 2 == 0) {
				evenArr[i] = num;
			}else {
				i--;
			}
		}
		sc.close();
		
		System.out.println("\n< 5개의 정수 출력 >");
		for(int i = 0; i < 5 ; i++) {
			System.out.print(evenArr[i] + " ");
		}
	}

}
