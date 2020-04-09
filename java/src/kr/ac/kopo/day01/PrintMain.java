package kr.ac.kopo.day01;

public class PrintMain {
	public static void main(String[] args) {
		//[\n] 문자를 출력 
		System.out.println("[\\n]");
		// 'M' 의 유니코드 값을 알고싶다면?
		char ch = 'M';
		System.out.printf("%d\n",(int)ch);
		System.out.println((int)ch);
		
		System.out.println('A' + 'B' + "hello" + true + 10); // A와 B의 16진수에 대한 더하기가 먼저 이루어짐		 
		System.out.println("hello" + 'A' + 'B'  + true + 10); // 문자합한 것 그대로 나옴 

		System.out.println(10 + "ABC");
		System.out.println(10 + 12.34);
		System.out.println('A' + "BC");
		System.out.println('A' + 'B'); //숫자나옴
		System.out.println(10 + 'A'); //숫자나옴
		
		System.out.printf("%-10d\t%s\n", 10, "ABC" );
		System.out.printf("%-10d\t%s\n", 1234, "AD" );
		System.out.printf("%-10d\t%s\n", 12345, "ABCD" );
		System.out.printf("%-10d\t%s\n",12345678, "AB" );
		System.out.printf("%.1f\n", 12.33 );
		System.out.printf("%.1f\n", 12.39 - 0.05 );
		
		
	}
}
