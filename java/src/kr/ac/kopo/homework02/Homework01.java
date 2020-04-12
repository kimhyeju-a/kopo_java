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
		
		//나올 수 있는 경우의 수 : abc, acb, bac, bca, cab, cba
		if(a > b) {
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
	}
}
