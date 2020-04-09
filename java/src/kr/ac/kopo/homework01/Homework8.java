package kr.ac.kopo.homework01;

import java.util.Scanner;

public class Homework8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		System.out.print("물건값을 입력하세요 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		System.out.print("지불한 돈의 액수를 입력하세요 : ");
		int pay = Integer.parseInt(sc.nextLine());
		
		//지불한 돈이 적을 때 
		if(price > pay) {
			int lack = price - pay;
			System.out.println(lack + "원이 부족합니다.");
		}else {
			//배열을 사용하여 반복되는 부분 코드 줄 줄임
			int remain = pay - price;
			int[] arr = {1000, 500, 100, 50, 10};
			System.out.println("거스름돈 : " + remain);
			for(int i = 0; i<5; i++) {
				int charge = remain / arr[i];
				System.out.println(arr[i]+"원 : " + charge + "개");
				remain -= charge * arr[i];
			}
		}
	}
}
