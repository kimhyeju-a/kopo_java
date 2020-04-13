package kr.ac.kopo.homework02;

import java.util.Scanner;
//1. 정수 3개를 입력받아 큰수에서 작은수 순으로 출력하는 코드를 작성하시오
public class Homework01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 3개를 입력하세요 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.nextLine();
		//JVM이 프로그램이 종료되더라도 System.in을 제대로 종료시키지 않기 때문에 I/O와 관련된 것들은 close로 종료시켜야 Resource leak 경고가 나지 않는다
		sc.close();
		
		
		/*
		혜주씨 조건문 쓰다가 머리 아파오지 않았어요???? 조건을 조금 줄여서 할 수 있는 방법을 생각해볼까요?????
		
		==> 수정완료
		*/
		
		int min = a, max = b;
		//a와 b를 비교해 max 와 min을 수정
		if(a < b) {
			min = b;
			max = a;
		}
		//c가 제일 큰경우
		if(c > max) {
			System.out.printf("%d %d %d",c ,max , min);
		}else if(c > min) {
			System.out.printf("%d %d %d",max ,c , min);
		}else {
			System.out.printf("%d %d %d",max ,min , c);
		}
		
		
		/*
		 * 피드백 받기 전, 코드
		if(a > b && b > c ) { 
			if(b > c) {
				//a > b > c
				System.out.printf("%d %d %d",a ,b, c);
			}else if (b < c) {
				if(a > c) {
					//a > c > b
					System.out.printf("%d %d %d",a ,c ,b );
				}else{
					//c > a > b
					System.out.printf("%d %d %d",c, a, b );
				}
			}
		}else{
			if(b > c) {
				if(c < a) {
					// b > a > c
					System.out.printf("%d %d %d", b, a, c);
				}
				else {
					//b > c > a
					System.out.printf("%d %d %d", b, c, a);
				}
			}else {
				//c > b > a
				System.out.printf("%d %d %d", c, b, a);
			}
		}
		*/
	}
}
