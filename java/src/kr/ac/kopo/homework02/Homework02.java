package kr.ac.kopo.homework02;

import java.util.Scanner;
//2. 4개의 정수를 입력받아 가장 큰수를 구하는 코드를 작성하시오.

public class Homework02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 4개를 입력하세요 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		sc.nextLine();
		sc.close();
		
		//max를 임의로 a로 설정한 후, a와  b,c,d를 비교하는 제어문을 각각 만들어 max변수에 넣는다.
		int max = a;
		
		if(max < b) {
			max = b;
		}
		if(max < c) {
			max = c;
		}
		if(max < d) {
			max = d;
		}
		
		System.out.printf("%d, %d, %d, %d 중 가장 큰 수 : %d",a ,b ,c ,d ,max);
	}
}