package kr.ac.kopo.homework01;

import java.util.Scanner;
// 3. 반지름이 10인 원의 면적을 구해서 출력하시오 
public class Homework3 {
	public static void main(String[] args) {
		final double PI = 3.141592;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("반지름을 입력하세요 : ");
		double r = Double.parseDouble(sc.nextLine());
		//면적 구하는 공식 PI*반지름*반지름
		double area = PI * r * r;
		System.out.println("원의 면적은 " + area + " 입니다.");
	}
}
