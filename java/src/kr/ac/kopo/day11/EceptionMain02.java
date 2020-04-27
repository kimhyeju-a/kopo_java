package kr.ac.kopo.day11;

import java.util.Random;

public class EceptionMain02 {

	public static void main(String[] args) {
		System.out.println("main start...");
		Random r = new Random();
		try {
			int num = r.nextInt(3);
			
			System.out.println("추출된 난수 : " + num);
			//0이 추출되면 ArithmeticException 발생으로 프로그램이 종료되므로 main end가 찍히지 않음
			System.out.println(10 / num);
		} catch(ArithmeticException ae) {
			System.out.println("예외발생!!!!!");
//			System.out.println("발생이유 " + ae.getMessage());
			ae.printStackTrace();
		} 
		System.out.println("main end...");
	}
}
