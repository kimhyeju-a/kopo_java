package kr.ac.kopo.day02;

import java.util.Random;

/*
	1 ~ 3 사이의 정수를 입력 :
	1 입력 시 "ONE" 출력
	2 입력 시 "TWO" 출력
	3 입력 시 "THREE" 출력
	그 외 "ERROR" 출력
	
	switch에 double 은 들어가지 않음 
 */
public class SwitchMain {
	public static void main(String[] args) {
		Random r = new Random();
		int num = r.nextInt(5) + 1;
		System.out.println("입력된 정수 : " + num);
		
		
		//default가 위에 있다고 하더라도 case가 더 먼저 실행됨 
		/*
		switch(num) {
		case 1 :
			System.out.println("ONE");
			break;
		default :
			System.out.println("ERROR");
		case 2 :
			System.out.println("TWO");
			break;
		case 3 :
			System.out.println("THREE");
			break;
		}
		*/
		
		//3일경우 THREE, ERROR가 출력됨 
		switch(num) {
		case 1 :
			System.out.println("ONE");
			break;
		case 2 :
			System.out.println("TWO");
			break;
		case 3 :
			System.out.println("THREE");
			break;
		default :
			System.out.println("ERROR");
		}
		
		/*
		if(num == 1) {
			System.out.println("ONE");
		} else if(num == 2) {
			System.out.println("TWO");
		} else if(num ==3) {
			System.out.println("THREE");
		} else {
			System.out.println("ERROR");
		}
		*/
		
	}
}
