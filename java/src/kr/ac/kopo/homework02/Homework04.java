package kr.ac.kopo.homework02;

import java.util.Scanner;
/*
	 4. 다음의 결과를 보이는 프로그램 작성하시오.
	 1 - 100 사이의 정수를 입력 : 40
	 2 - 10사이의 정수를 입력 : 5
 */
public class Homework04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("1 - 100 사이의 정수를 입력 : ");
		int num1 = Integer.parseInt(sc.nextLine());

		System.out.print("2 - 10 사이의 정수를 입력 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		sc.close();
		
		System.out.printf("< 1 ~ %d 사이의 %d 의 배수를 제외한 정수 출력 > \n", num1, num2);
		for(int i = 1; i <= num1 ; i++ ) {
			//i / num2의 나머지가 0이 아닐 때만 print문 사용
			if(i % num2 !=0) {
				System.out.printf("%d ", i);
			}
		}
		System.out.print("\n\n");
		
		
		System.out.printf("< 1 ~ %d 사이의 %d 의 배수를 제외한 정수 %d개씩 출력 >\n", num1, num2, num2);
		//줄바꿈을 위한 cnt 변수 선언 
		int cnt = 0;
		
		for(int i = 1; i <= num1 ; i++ ) {
			//i / num2의 나머지가 0이 아닐 때만 print문 사용
			if(i % num2 !=0) {
				System.out.printf("%d ", i);
				cnt++;
			}
			//cnt가 num2 와 같다면 줄바꿈 및 cnt 0으로 초기화
			if(cnt == num2) {
				System.out.print('\n');
				cnt = 0;
			}
		}
		
	}
}
