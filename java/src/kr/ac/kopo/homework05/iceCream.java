package kr.ac.kopo.homework05;

import java.util.Scanner;

public class iceCream {
	String name;
	int price;
	
	iceCream[] setIce(int num) {
		Scanner sc = new Scanner(System.in);
		iceCream[] ice = new iceCream[num];
		for(int i = 0; i < ice.length; i++) {			
			ice[i] = new iceCream();
			System.out.println("*** "+ (i+1) + "번째 아이스크림 구매 정보 ***");
			System.out.print("아이스크림명 : ");
			ice[i].name = sc.nextLine();
			System.out.print("아이스크림가격 : ");
			ice[i].price = Integer.parseInt(sc.nextLine());
		}
		sc.close();
		return ice;
	}
	
	void printIce(iceCream[] ice) {
		System.out.println();
		System.out.println("< 총 " + ice.length +"개의 아이스크림 구매 정보 출력>");
		System.out.println("번호\t 아이스크림명 \t 아이스크림가격");
		for(int i = 0; i < ice.length; i++) {
			System.out.printf("%d\t %s\t\t %d\t\n", i+1 , ice[i].name, ice[i].price);
		}
	}
}
