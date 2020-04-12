package kr.ac.kopo.homework02;

import java.util.Scanner;

//8. 시작단과 종료단을 입력받아 구구단을 출력하시오.
public class Homework08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("시작단을 입력 : ");
		int start = sc.nextInt();
		System.out.print("종료단을 입력 : ");
		int end = sc.nextInt();
		sc.close();
		
		
		//시작단을 8, 종료단을 5 입력해도 같은 결과가 나와야 하므로 종료단이 시작단보다 작으면 스와이프
		if(start > end) {
			int temp = start;
			start = end;
			end = temp;
		}
		
		//시작단과 종료단을 반복문에 맞게 넣음
		for(int i = start; i <= end; i++) {
			System.out.println("*** "+ i +"단 ***");
			//j와 i(1~9)를 곱함 
			for(int j = 1 ; j <= 9; j++) {
				System.out.printf("%d * %d = %d\n",i , j, i*j);
			}
			System.out.print('\n');
		}
	}
}
