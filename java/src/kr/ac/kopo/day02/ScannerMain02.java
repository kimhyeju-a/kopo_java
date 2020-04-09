package kr.ac.kopo.day02;

import java.util.Scanner;

public class ScannerMain02 {
	public static void main(String[] args) {
		/*
		 * 문자열을 입력 : hello world
		 * 정수를 입력 : 123
		 * 문자열 : hello world 정수 : 123
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력 : ");
		String str = sc.nextLine();
		
		System.out.print("정수를 입력 : ");
		int num = sc.nextInt();
		/*
		 * 정수 입력을 받고, 문자열입력을 받을 때에는 오류가 발생
		 * => 입력 버퍼를 사용하기 때문에 문제가 생김
		 * => 키보드가 버퍼에 line by line 로 저장하게됨 -> 버퍼에서 Ram으로 변수 저장
		 * 
		 * buffer에 nextInt 를 사용하게 되면 buffer에 123\n 이 저장됨
		 * num에 123 이 저장되고, 버퍼에는 \n이 남아있게됨
		 * nextLine이 \n을 만나면서 비어있는 문자열이 됨
		 * 
		 * nextLine으 사용하게 되면 [\n]까지 소비하게됨
		 * 
		 * 해결법 : nextInt()를 입력하면 sc.nextLine()으로 \n을 소비함, 정수나 실수를 입력받을 때 nextLine을 사용 (문자열로 받음 )
		 * int num = Integer.parseInt(sc.nextLine());
		 * Double.parseDouble(nextDouble())
		 */
//		System.out.println("문자열 입력 : ");
//		String str = sc.nextLine();
		
		
		
		System.out.println("문자열 : " + str + ", 정수: " + num);
		
		/*
		 * 첫번째 정수를 입력 : 10 20
		 * 을하게되면 버퍼에 10 20\n이 됨 
		 * 버퍼에 10 을 먼저 소비하고 공백은 없애버림, 버퍼에 20\n이 되어 있으니 num2=sc.nextInt();에
		 * 저절로 20을 입력하게됨
		 */
		System.out.print("첫번째 정수를 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력 : ");
		int num2 = sc.nextInt();
		System.out.println("첫번째 : " + num1 + ", 두번째: " + num2);
		
		
		
	}
}
