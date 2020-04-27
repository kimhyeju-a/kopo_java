package kr.ac.kopo.day11;

import java.util.Random;

public class ExceptionMain01 {

	public static void main(String[] args) {
		System.out.println("main start...");
		Random r = new Random();
		int num = r.nextInt(3);
		
		System.out.println("추출된 난수 : " + num);
		//0이 추출되면 ArithmeticException 발생으로 프로그램이 종료되므로 main end가 찍히지 않음
		System.out.println(10 / num);
		
		System.out.println("main end...");
	}
}
