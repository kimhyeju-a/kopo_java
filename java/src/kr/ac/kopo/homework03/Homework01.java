package kr.ac.kopo.homework03;

import java.util.Scanner;
/* 1. 10개의 정수를 입력받아 다음과 같이 출력하는 코드를 작성하시오.
	 1's num : 12
	 2's num : 5
	 3's num : 8
	 4's num : 30
	 5's num : 22
	 6's num : 87
	 7's num : 9
	 8's num : 4
	 9's num : 15
	 10's num : 22
	
	 < 짝수 >
	 12 8 30 22 4 22
	 짝수의 총합 : XXX
	
	 < 홀수 >
	 5 87 9 15
	 홀수의 총합 : XXX
*/

public class Homework01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] oddArr = new int[10];
		int[] evenArr = new int[10];
		int oddidx = 0;
		int evenidx = 0;
		int sum = 0;
		
		//입력받은 정수를 짝수, 홀수 구분하여 각각의 배열에 출력
		for(int i = 0; i < 10; i++) {
			System.out.print(i+1 +"'s num : ");
			int num = sc.nextInt();
			if(num % 2 == 0) {
				evenArr[evenidx++] = num;
			}else {
				oddArr[oddidx++] = num;
			}
		}
		sc.close();
		
		//oddidx ,evenidx 만큼만 숫자가 들어 있으니, idx까지만 반복문 수행
		System.out.println("\n< 짝수 >");
		for(int i = 0; i < evenidx ; i++) {
			System.out.print(evenArr[i] + " ");
			sum += evenArr[i];
		}
		System.out.println();
		System.out.println("짝수의 총합 : "+ sum);
		sum = 0;

		System.out.println("\n< 홀수 >");
		for(int i = 0; i < oddidx ; i++) {
			System.out.print(oddArr[i] + " ");
			sum += oddArr[i];
		}
		System.out.println();
		System.out.println("홀수의 총합 : "+ sum);
	}

}
