package kr.ac.kopo.homework02;

//7. 구구단을 출력하세요

public class Homework07 {
	public static void main(String[] args) {
		for(int i = 2; i <= 9; i++) {
			System.out.println("*** "+ i +"단 ***");
			//j와 i(1~9)를 곱함 
			for(int j = 1 ; j <= 9; j++) {
				System.out.printf("%d * %d = %d\n",i , j, i*j);
			}
			System.out.print('\n');
		}
	}
}
