package kr.ac.kopo.homework02;

import java.util.Scanner;

//3. 정수를 입력받아 1에서부터 입력받은 정수사이의 숫자를 출력하는 코드를 작성

public class Homework03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("1 - 100사이의 정수를 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		sc.close();
		//i를 1부터 입력받은 수까지 반복문을 돌림.
		for(int i = 1; i <= num; i++) {
			System.out.printf("%d ",i);
		}
	}
}
